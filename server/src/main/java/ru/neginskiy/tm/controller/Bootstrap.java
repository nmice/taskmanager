package ru.neginskiy.tm.controller;

import ru.neginskiy.tm.api.*;
import ru.neginskiy.tm.connection.DBConnection;
import ru.neginskiy.tm.endpoint.*;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.SessionRepository;
import ru.neginskiy.tm.repository.TaskRepository;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.UserRepository;
import ru.neginskiy.tm.service.*;

import javax.xml.ws.Endpoint;
import java.sql.*;

public class Bootstrap implements ServiceLocator {

    private final DBConnection dbConnection = new DBConnection();

    private ITaskService taskService;
    private IProjectService projectService;
    private IUserService userService;
    private ISessionService sessionService;

    private DataService dataService;

    public void init() {
        dbConnection.initDB();
        Connection connection = dbConnection.getConnection();

        final TaskRepository taskRepository = new TaskRepository(connection);
        final ProjectRepository projectRepository = new ProjectRepository(connection);
        final UserRepository userRepository = new UserRepository(connection);
        final SessionRepository sessionRepository = new SessionRepository(connection);

        taskService = new TaskService(taskRepository);
        projectService = new ProjectService(projectRepository, taskRepository);
        userService = new UserService(userRepository);
        sessionService = new SessionService(sessionRepository);
        dataService = new DataService(this);

        createTestUser();

        registryInNet();
    }

    private void createTestUser() {
        User testUser = new User();
        testUser.setLogin("test");
        testUser.setPasswordHash(String.valueOf(("test").hashCode()));
        getUserService().merge(testUser);
    }

    private void registryInNet() {
        Endpoint.publish("http://localhost:1234/TaskEndpoint?wsdl", new TaskEndpoint(this));
        Endpoint.publish("http://localhost:1234/ProjectEndpoint?wsdl", new ProjectEndpoint(this));
        Endpoint.publish("http://localhost:1234/UserEndpoint?wsdl", new UserEndpoint(userService));
        Endpoint.publish("http://localhost:1234/SessionEndpoint?wsdl", new SessionEndpoint(sessionService));
        Endpoint.publish("http://localhost:1234/DataEndpoint?wsdl", new DataEndpoint(this));
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

    public DataService getDataService() {
        return dataService;
    }

    public Connection getConnection() {
        return dbConnection.getConnection();
    }
}