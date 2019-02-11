package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.neginskiy.tm.util.SqlDateUtil.prepare;

public class SessionRepository extends AbstractRepository<Session> {

    public SessionRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void merge(Session session) {
        final String query = "INSERT INTO session (id,signature,timeStamp,userId) VALUES (?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE id = VALUES(id), signature = VALUES(signature), " +
                "timeStamp = VALUES(timeStamp), userId = VALUES(userId)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, session.getId());
            preparedStatement.setString(2, session.getSignature());
            preparedStatement.setDate(3, prepare(session.getTimeStamp()));
            preparedStatement.setString(4, session.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Session getById(String id) {
        final String query = "SELECT * FROM session where id=?";
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
    public List<Session> getAll() {
        final String query = "SELECT * FROM session";
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
    public Session delete(String id) {
        final Session session = getById(id);
        final String query = "DELETE FROM session where id=?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }

    protected Session fetch(ResultSet resultSet) throws SQLException {
        final Session session = new Session();
        session.setId(resultSet.getString("id"));
        session.setSignature(resultSet.getString("signature"));
        session.setTimeStamp(prepare(resultSet.getDate("timeStamp")));
        session.setUserId(resultSet.getString("userId"));
        return session;
    }

    protected List<Session> fetchAll(ResultSet resultSet) throws SQLException {
        final List<Session> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(fetch(resultSet));
        }
        return resultList;
    }
}
