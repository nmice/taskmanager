package ru.neginskiy.tm.controller;

import lombok.Getter;
import ru.neginskiy.tm.api.*;
import ru.neginskiy.tm.api.service.IProjectService;
import ru.neginskiy.tm.api.service.ISessionService;
import ru.neginskiy.tm.api.service.ITaskService;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.endpoint.*;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.service.*;

import static ru.neginskiy.tm.util.AppConfig.*;

import javax.persistence.EntityManagerFactory;
import javax.xml.ws.Endpoint;

import static ru.neginskiy.tm.util.HibernateSessionFactory.createEntityManagerFactory;

@Getter
public class Bootstrap implements ServiceLocator {


    private final ServiceLocator serviceLocator = this;
    private final DataService dataService = new DataService(serviceLocator);
    private final ITaskService taskService = new TaskService(serviceLocator);
    private final IProjectService projectService = new ProjectService(serviceLocator);
    private final IUserService userService = new UserService(serviceLocator);
    private final ISessionService sessionService = new SessionService(serviceLocator);
    private final TaskEndpoint taskEndpoint = new TaskEndpoint(serviceLocator);
    private final ProjectEndpoint projectEndpoint = new ProjectEndpoint(serviceLocator);
    private final UserEndpoint userEndpoint = new UserEndpoint(serviceLocator);
    private final SessionEndpoint sessionEndpoint = new SessionEndpoint(serviceLocator);
    private final DataEndpoint dataEndpoint = new DataEndpoint(serviceLocator);
    private final EntityManagerFactory entityManagerFactory = createEntityManagerFactory();

    public void init() {
        createTestUser();
        registryInNet();
    }

    private void createTestUser() {
        final User testUser = new User();
        testUser.setId("dba0d409-0622-4c62-8356-4bc48bdfcbf3");
        testUser.setLogin("test");
        testUser.setPasswordHash(String.valueOf(("test").hashCode()));
        getUserService().merge(testUser);
    }

    private void registryInNet() {
        Endpoint.publish("http://" + host + ":" + port + "/" + taskEndpoint.getClass().getName() + "?wsdl", taskEndpoint);
        Endpoint.publish("http://" + host + ":" + port + "/" + projectEndpoint.getClass().getName() + "?wsdl", projectEndpoint);
        Endpoint.publish("http://" + host + ":" + port + "/" + userEndpoint.getClass().getName() + "?wsdl", userEndpoint);
        Endpoint.publish("http://" + host + ":" + port + "/" + sessionEndpoint.getClass().getName() + "?wsdl", sessionEndpoint);
        Endpoint.publish("http://" + host + ":" + port + "/" + dataEndpoint.getClass().getName() + "?wsdl", dataEndpoint);
    }
}