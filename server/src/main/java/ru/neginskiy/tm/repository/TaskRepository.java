package ru.neginskiy.tm.repository;

import org.apache.ibatis.session.SqlSessionFactory;
import ru.neginskiy.tm.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.neginskiy.tm.util.SqlDateUtil.prepare;

public class TaskRepository extends AbstractRepository<Task> {

    public TaskRepository(Connection connection, SqlSessionFactory sqlSessionFactory) {
        this.connection = connection;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Task> getAllByUserId(String userId) {
        final String query = "SELECT * FROM task where userId=?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            return fetchAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    public void deleteByProjectId(String projectId) {
        final String query = "DELETE FROM task where projectId=?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, projectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void merge(Task task) {
        final String query = "INSERT INTO task (id,name,description,dateBegin,dateEnd,projectId,userId) VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE id = VALUES(id), name = VALUES(name), description = VALUES(description), " +
                "dateBegin = VALUES(dateBegin), dateEnd = VALUES(dateEnd), projectId = VALUES(projectId), userId = VALUES(userId)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, task.getId());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setDate(4, prepare(task.getDateBegin()));
            preparedStatement.setDate(5, prepare(task.getDateEnd()));
            preparedStatement.setString(6, task.getProjectId());
            preparedStatement.setString(7, task.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Task getById(String id) {
        final String query = "SELECT * FROM task where id=?";
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
    public List<Task> getAll() {
        final String query = "SELECT * FROM task";
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
    public Task delete(String id) {
        final Task task = getById(id);
        final String query = "DELETE FROM task where id=?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    protected Task fetch(ResultSet resultSet) throws SQLException {
        final Task task = new Task();
        task.setId(resultSet.getString("id"));
        task.setName(resultSet.getString("name"));
        task.setDescription(resultSet.getString("description"));
        task.setDateBegin(prepare(resultSet.getDate("dateBegin")));
        task.setDateEnd(prepare(resultSet.getDate("dateEnd")));
        task.setProjectId(resultSet.getString("projectId"));
        task.setUserId(resultSet.getString("userId"));
        return task;
    }

    @Override
    protected List<Task> fetchAll(ResultSet resultSet) throws SQLException {
        final List<Task> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(fetch(resultSet));
        }
        return resultList;
    }
}