package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProjectRepository extends AbstractRepository<Project> {

    public ProjectRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Project> getAllByUserId(String userId) {
        List<Project> resultList = new ArrayList<>();
        String query = "SELECT * FROM project where 'userId'=?";
//        String query = "INSERT INTO `user` VALUES (?,?,?);";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
//            preparedStatement.setString(1, "id");
//            preparedStatement.setString(2, "user");
//            preparedStatement.setString(3, "password");
//            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();//.getResultSet();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getString("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setDateBegin(resultSet.getDate("dateBegin"));
                project.setDateEnd(resultSet.getDate("dateEnd"));
                project.setUserId(resultSet.getString("userId"));
                resultList.add(project);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void merge(Project entity) {
/*        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO `user` VALUES (?,?,?);");

            preparedStatement.setString(1, "id");
            preparedStatement.setString(2, "user");
            preparedStatement.setString(3, "password");
            preparedStatement.execute();
            //statement.execute("INSERT INTO `user` (id,login,passwordHash) VALUES ('1234','MIKE',36050252useruser');");
            ResultSet resultSet = statement.executeQuery("INSERT INTO `user` (id,login,passwordHash) VALUES ('1234','MIKE',36050252useruser');");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString(1));
                user.setLogin(resultSet.getString(2));
                //ResultSet resultSet = statement.executeQuery("SELECT * FROM ");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }*/
        //ResultSet resultSet = statement.executeQuery("SELECT * FROM ");
            /*      String INSERT_NEW = "INSERT INTO `user` VALUES (?,?,?);";
        PreparedStatement preparedStatement = null;
        try {
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement(INSERT_NEW);

            preparedStatement.setString(1,"id");
            preparedStatement.setString(2,"user");
            preparedStatement.setString(3,"password");
            preparedStatement.execute();
            //statement.execute("INSERT INTO `user` (id,login,passwordHash) VALUES ('1234','MIKE',36050252useruser');");
            ResultSet resultSet = statement.executeQuery("INSERT INTO `user` (id,login,passwordHash) VALUES ('1234','MIKE',36050252useruser');");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString(1));
                user.setLogin(resultSet.getString(2));
            }
        //entityBase.put(entity.getId(), entity);*/
    }

    @Override
    public Project getById(String id) {
        return null;
    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public Project delete(String id) {
        return null;
    }
}
