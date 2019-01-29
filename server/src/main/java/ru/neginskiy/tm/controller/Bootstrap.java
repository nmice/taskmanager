package ru.neginskiy.tm.controller;

import ru.neginskiy.tm.api.*;
import ru.neginskiy.tm.endpoint.ProjectEndpoint;
import ru.neginskiy.tm.endpoint.SessionEndpoint;
import ru.neginskiy.tm.endpoint.TaskEndpoint;
import ru.neginskiy.tm.endpoint.UserEndpoint;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.SessionRepository;
import ru.neginskiy.tm.repository.TaskRepository;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.UserRepository;
import ru.neginskiy.tm.service.ProjectService;
import ru.neginskiy.tm.service.SessionService;
import ru.neginskiy.tm.service.TaskService;
import ru.neginskiy.tm.service.UserService;

import javax.xml.ws.Endpoint;
import java.sql.*;

public class Bootstrap implements ServiceLocator {

    private final TaskRepository taskRepository = new TaskRepository();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final UserRepository userRepository = new UserRepository();
    private final SessionRepository sessionRepository = new SessionRepository();

    private final ITaskService taskService = new TaskService(taskRepository);
    private final IProjectService projectService = new ProjectService(projectRepository, taskRepository);
    private final IUserService userService = new UserService(userRepository);
    private final ISessionService sessionService = new SessionService(sessionRepository);

    public void init() {
        registryInNet();
        if (userService.getAll().size() == 0) {
            createTestUser();
        }
        String url = "jdbc:mysql://localhost:3636/tm_database";
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTestUser() {
        User testUser = new User();
        testUser.setLogin("test");
        testUser.setPassword(String.valueOf(("test").hashCode()));
        getUserService().merge(testUser);
    }

    private void registryInNet() {
        Endpoint.publish("http://localhost:8080/TaskEndpoint?wsdl", new TaskEndpoint(this));
        Endpoint.publish("http://localhost:8080/ProjectEndpoint?wsdl", new ProjectEndpoint(this));
        Endpoint.publish("http://localhost:8080/UserEndpoint?wsdl", new UserEndpoint(userService));
        Endpoint.publish("http://localhost:8080/SessionEndpoint?wsdl", new SessionEndpoint(sessionService));
    }

    public IProjectService getProjectService() {
        return projectService;
    }

    public ITaskService getTaskService() {
        return taskService;
    }

    public IUserService getUserService() {
        return userService;
    }

    public ISessionService getSessionService() {
        return sessionService;
    }
}