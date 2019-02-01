package ru.neginskiy.tm.controller;

import ru.neginskiy.tm.api.*;
import ru.neginskiy.tm.connection.DBConnection;
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
import ru.neginskiy.tm.util.AppConfig;

import javax.xml.ws.Endpoint;
import java.sql.*;

public class Bootstrap implements ServiceLocator {

    private final DBConnection dbConnection = new DBConnection();

    private ITaskService taskService;
    private IProjectService projectService;
    private IUserService userService;
    private ISessionService sessionService;

    public void init() {
        AppConfig.init();
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

        createTestUser();

        registryInNet();
        if (userService.getAll().size() == 0) {
            //createTestUser();
        }
    }

    private void createTestUser() {
        User testUser = new User();
        testUser.setLogin("test");
        testUser.setPasswordHash(String.valueOf(("test").hashCode()));
        getUserService().merge(testUser);
        User testUser2 = new User();
        testUser2.setLogin("test2");
        testUser2.setPasswordHash(String.valueOf(("test2").hashCode()));
        getUserService().merge(testUser2);
    }

    private void registryInNet() {
        Endpoint.publish("http://localhost:1234/TaskEndpoint?wsdl", new TaskEndpoint(this));
        Endpoint.publish("http://localhost:1234/ProjectEndpoint?wsdl", new ProjectEndpoint(this));
        Endpoint.publish("http://localhost:1234/UserEndpoint?wsdl", new UserEndpoint(userService));
        Endpoint.publish("http://localhost:1234/SessionEndpoint?wsdl", new SessionEndpoint(sessionService));
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

    public Connection getConnection() {
        return dbConnection.getConnection();
    }
}