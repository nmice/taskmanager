package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.neginskiy.tm.util.SqlDateUtil.prepare;

public class TaskRepository extends AbstractRepository<Task> {

    public TaskRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Task> getAllByUserId(String userId) {
        List<Task> resultList = new ArrayList<>();
        String query = "SELECT * FROM task where userId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getString("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setDateBegin(prepare(resultSet.getDate("dateBegin")));
                task.setDateEnd(prepare(resultSet.getDate("dateEnd")));
                task.setProjectId(resultSet.getString("projectId"));
                task.setUserId(resultSet.getString("userId"));
                resultList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;



    }

    public void deleteByProjectId(String projectId) {
        String query = "DELETE FROM task where projectId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, projectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void merge(Task task) {
        String query = "INSERT INTO task (id,name,description,dateBegin,dateEnd,projectId,userId) VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE id = VALUES(id), name = VALUES(name), description = VALUES(description), " +
                "dateBegin = VALUES(dateBegin), dateEnd = VALUES(dateEnd), projectId = VALUES(projectId), userId = VALUES(userId)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, task.getId());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setDate(4, prepare(task.getDateBegin()));
            preparedStatement.setDate(5, prepare(task.getDateEnd()));
            preparedStatement.setString(6, task.getProjectId());
            preparedStatement.setString(7, task.getUserId());
            /*int euReturnValue = */
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Task getById(String id) {
        Task task = new Task();
        String query = "SELECT * FROM task where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                task.setId(resultSet.getString("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setDateBegin(prepare(resultSet.getDate("dateBegin")));
                task.setDateEnd(prepare(resultSet.getDate("dateEnd")));
                task.setProjectId(resultSet.getString("projectId"));
                task.setUserId(resultSet.getString("userId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public List<Task> getAll() {
        List<Task> resultList = new ArrayList<>();
        String query = "SELECT * FROM task";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getString("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setDateBegin(prepare(resultSet.getDate("dateBegin")));
                task.setDateEnd(prepare(resultSet.getDate("dateEnd")));
                task.setProjectId(resultSet.getString("projectId"));
                task.setUserId(resultSet.getString("userId"));
                resultList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public Task delete(String id) {
        Task task = getById(id);
        String query = "DELETE FROM task where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }
}