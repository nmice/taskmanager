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

    private static final int SESSION_LIFETIME = 1800_000;//30 minutes

    public SessionRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean isUncorrectSession(Session session) {
        Session sessionInBase = getById(session.getId());
        if (sessionInBase == null || !sessionInBase.getSignature().equals(session.getSignature())) {//Session is not in a repository OR Signature is incorrect
            return true;
        }
        if (System.currentTimeMillis() - session.getTimeStamp().getTime() > SESSION_LIFETIME) {//Session is correct, but older than 30min
            delete(session.getId());
            return true;
        }
        return false;
    }

    @Override
    public void merge(Session session) {
        String query = "INSERT INTO session (id,signature,timeStamp,userId) VALUES (?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE id = VALUES(id), signature = VALUES(signature), " +
                "timeStamp = VALUES(timeStamp), userId = VALUES(userId)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, session.getId());
            preparedStatement.setString(2, session.getSignature());
            preparedStatement.setDate(3, prepare(session.getTimeStamp()));
            preparedStatement.setString(4, session.getUserId());
            /*int euReturnValue = */
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Session getById(String id) {
        Session session = new Session();
        String query = "SELECT * FROM session where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                session.setId(resultSet.getString("id"));
                session.setSignature(resultSet.getString("signature"));
                session.setTimeStamp(prepare(resultSet.getDate("timeStamp")));
                session.setUserId(resultSet.getString("userId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }

    @Override
    public List<Session> getAll() {
        List<Session> resultList = new ArrayList<>();
        String query = "SELECT * FROM session";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Session session = new Session();
                session.setId(resultSet.getString("id"));
                session.setSignature(resultSet.getString("signature"));
                session.setTimeStamp(prepare(resultSet.getDate("timeStamp")));
                session.setUserId(resultSet.getString("userId"));
                resultList.add(session);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public Session delete(String id) {
        Session session = getById(id);
        String query = "DELETE FROM session where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }
}
