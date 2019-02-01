package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectRepository extends AbstractRepository<Project> {

    public ProjectRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Project> getAllByUserId(String userId) {
        List<Project> resultList = new ArrayList<>();
        String query = "SELECT * FROM project where 'userId'=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();//.getResultSet();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getString("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setDateBegin(new Date(resultSet.getDate("dateBegin").getTime()));
                project.setDateEnd(new Date(resultSet.getDate("dateEnd").getTime()));
                project.setUserId(resultSet.getString("userId"));
                resultList.add(project);
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
    public void merge(Project project) {
        String query = "INSERT INTO project (id,name,description,dateBegin,dateEnd,userId) VALUES (?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE id = VALUES(id), name = VALUES(name), description = VALUES(description), " +
                "dateBegin = VALUES(dateBegin), dateEnd = VALUES(dateEnd), userId = VALUES(userId)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, project.getId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.setDate(4, new java.sql.Date(project.getDateBegin().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(project.getDateEnd().getTime()));
            preparedStatement.setString(6, project.getUserId());
            /*int euReturnValue = */
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
    }

    @Override
    public Project getById(String id) {
        Project project = new Project();
        String query = "SELECT * FROM project where 'id'=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                project.setId(resultSet.getString("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setDateBegin(new Date(resultSet.getDate("dateBegin").getTime()));
                project.setDateEnd(new Date(resultSet.getDate("dateEnd").getTime()));
                project.setUserId(resultSet.getString("userId"));
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
        return project;
    }

    @Override
    public List<Project> getAll() {
        List<Project> resultList = new ArrayList<>();
        String query = "SELECT * FROM project";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getString("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setDateBegin(new Date(resultSet.getDate("dateBegin").getTime()));
                project.setDateEnd(new Date(resultSet.getDate("dateEnd").getTime()));
                project.setUserId(resultSet.getString("userId"));
                resultList.add(project);
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
    public Project delete(String id) {
        Project project = getById(id);
        String query = "DELETE FROM project where 'id'=?";
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
        return project;
    }
}
