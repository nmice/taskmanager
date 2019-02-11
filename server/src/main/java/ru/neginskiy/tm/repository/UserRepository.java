package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public User findUser(String login, String passwordHash) {
        final String query = "SELECT * FROM `user` WHERE login=? AND passwordHash=?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, passwordHash);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return fetch(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isRegistredLogin(String login) {
        final String query = "SELECT * FROM `user` where login=?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            final ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void merge(User user) {
        final String query = "INSERT INTO `user` (id,login,passwordHash) VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE login = VALUES(login), passwordHash = VALUES(passwordHash)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPasswordHash());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(String id) {
        final String query = "SELECT * FROM `user` where id=?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return fetch(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        final String query = "SELECT * FROM `user`";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            final ResultSet resultSet = preparedStatement.executeQuery();
            return fetchAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public User delete(String id) {
        final User user = getById(id);
        final String query = "DELETE FROM `user` where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    protected User fetch(ResultSet resultSet) throws SQLException {
        final User user = new User();
        user.setId(resultSet.getString("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPasswordHash(resultSet.getString("passwordHash"));
        return user;
    }

    protected List<User> fetchAll(ResultSet resultSet) throws SQLException {
        final List<User> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(fetch(resultSet));
        }
        return resultList;
    }
}
