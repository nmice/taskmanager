package ru.neginskiy.tm.api;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.neginskiy.tm.entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.neginskiy.tm.util.SqlDateUtil.prepare;

public interface IProjectRepository extends IRepository {

    @Select("SELECT * FROM project where userId=(#{userId}")
    List<Project> getAllByUserId(String userId);

    @Insert("INSERT INTO project (id,name,description,dateBegin,dateEnd,userId) VALUES (?, ?, ?, ?, ?, ?) " +
            "ON DUPLICATE KEY UPDATE id = VALUES(id), name = VALUES(name), description = VALUES(description), " +
            "dateBegin = VALUES(dateBegin), dateEnd = VALUES(dateEnd), userId = VALUES(userId)")
    void merge(Project project) {
        final String query = "INSERT INTO project (id,name,description,dateBegin,dateEnd,userId) VALUES (?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE id = VALUES(id), name = VALUES(name), description = VALUES(description), " +
                "dateBegin = VALUES(dateBegin), dateEnd = VALUES(dateEnd), userId = VALUES(userId)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, project.getId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.setDate(4, prepare(project.getDateBegin()));
            preparedStatement.setDate(5, prepare(project.getDateEnd()));
            preparedStatement.setString(6, project.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getById(String id) {
        final String query = "SELECT * FROM project where id=?";
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
    public List<Project> getAll() {
        final String query = "SELECT * FROM project";
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
    public Project delete(String id) {
        final Project project = getById(id);
        final String query = "DELETE FROM project where id=?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    protected Project fetch(ResultSet resultSet) throws SQLException {
        final Project project = new Project();
        project.setId(resultSet.getString("id"));
        project.setName(resultSet.getString("name"));
        project.setDescription(resultSet.getString("description"));
        project.setDateBegin(prepare(resultSet.getDate("dateBegin")));
        project.setDateEnd(prepare(resultSet.getDate("dateEnd")));
        project.setUserId(resultSet.getString("userId"));
        return project;
    }

    @Override
    protected List<Project> fetchAll(ResultSet resultSet) throws SQLException {
        final List<Project> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(fetch(resultSet));
        }
        return resultList;
    }

}
