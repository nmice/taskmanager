package ru.neginskiy.tm.controller;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
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

import javax.persistence.EntityManagerFactory;
import javax.xml.ws.Endpoint;
import java.util.HashMap;
import java.util.Map;

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
        final EntityManagerFactory entityManagerFactory = createEntityManagerFactory();

        final TaskRepository taskRepository = new TaskRepository(entityManagerFactory);
        final ProjectRepository projectRepository = new ProjectRepository(entityManagerFactory);
        final UserRepository userRepository = new UserRepository(entityManagerFactory);
        final SessionRepository sessionRepository = new SessionRepository(entityManagerFactory);

        taskService = new TaskService(taskRepository);
        projectService = new ProjectService(projectRepository, taskRepository);
        userService = new UserService(userRepository);
        sessionService = new SessionService(sessionRepository);
        dataService = new DataService(this);

        createTestUser();
        registryInNet();
    }

    private @NotNull EntityManagerFactory createEntityManagerFactory() {
        final Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, jdbcDriver);
        settings.put(Environment.URL, url);
        settings.put(Environment.USER, username);
        settings.put(Environment.PASS, password);
        settings.put(Environment.DIALECT, hDialect);
        settings.put(Environment.HBM2DDL_AUTO, hbm2ddlAuto);
        settings.put(Environment.SHOW_SQL, hShowWQL);
        final StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(settings);
        final StandardServiceRegistry registry = registryBuilder.build();
        final MetadataSources sources = new MetadataSources(registry);
        for (Class anotationClass : ANNOTATION_CLASSES) {
            sources.addAnnotatedClass(anotationClass);
        }
        final Metadata metadata = sources.getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
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