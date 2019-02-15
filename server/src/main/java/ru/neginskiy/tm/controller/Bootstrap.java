package ru.neginskiy.tm.controller;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.api.*;
import ru.neginskiy.tm.api.service.IProjectService;
import ru.neginskiy.tm.api.service.ISessionService;
import ru.neginskiy.tm.api.service.ITaskService;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.endpoint.*;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.SessionRepository;
import ru.neginskiy.tm.repository.TaskRepository;
import ru.neginskiy.tm.repository.UserRepository;
import ru.neginskiy.tm.service.*;
import ru.neginskiy.tm.util.AppConfig;

import javax.xml.ws.Endpoint;
import java.util.Properties;

import static ru.neginskiy.tm.util.AppConfig.*;

public class Bootstrap implements ServiceLocator {

    private static final Class[] ANNOTATION_CLASSES = {User.class, Task.class,
            Project.class, Session.class};

    private ITaskService taskService;
    private IProjectService projectService;
    private IUserService userService;
    private ISessionService sessionService;
    private DataService dataService;

    public void init() {
        final SessionFactory sessionFactory = createSessionFactory();

        final TaskRepository taskRepository = new TaskRepository(sessionFactory);
        final ProjectRepository projectRepository = new ProjectRepository(sessionFactory);
        final UserRepository userRepository = new UserRepository(sessionFactory);
        final SessionRepository sessionRepository = new SessionRepository(sessionFactory);

        taskService = new TaskService(taskRepository);
        projectService = new ProjectService(projectRepository, taskRepository);
        userService = new UserService(userRepository);
        sessionService = new SessionService(sessionRepository);
        dataService = new DataService(this);

        createTestUser();

        registryInNet();
    }

private @NotNull SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.driver_class", dbDriver)
                .setProperty("hibernate.connection.url", dbUrl)
                .setProperty("hibernate.connection.username", dbUsername)
                .setProperty("hibernate.connection.password", dbPassword)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
    for (Class anotationClass : ANNOTATION_CLASSES) {
            configuration.addAnnotatedClass(anotationClass);
        }
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
    }

    private void createTestUser() {
        User testUser = new User();
        testUser.setId("dba0d409-0622-4c62-8356-4bc48bdfcbf3");
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
}