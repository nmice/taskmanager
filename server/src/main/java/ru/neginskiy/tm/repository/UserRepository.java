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
        User user = new User();
        String query = "SELECT * FROM `user` WHERE 'login'=? AND 'passwordHash'=? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, passwordHash);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getString("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPasswordHash(resultSet.getString("passwordHash"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //return null;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    public boolean isRegistredLogin(String login) {
        String query = "SELECT * FROM `user` where 'login'=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public void merge(User user) {

    }

    @Override
    public User getById(String id) {
        User user = new User();
        String query = "SELECT * FROM `user` where 'id'=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getString("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPasswordHash(resultSet.getString("passwordHash"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> resultList = new ArrayList<>();
        String query = "SELECT * FROM `user`";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPasswordHash(resultSet.getString("passwordHash"));
                resultList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultList;
    }

    @Override
    public User delete(String id) {
        User user = getById(id);
        String query = "DELETE FROM `user` where 'id'=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
