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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@ApplicationScoped
@Getter
public class Bootstrap implements ServiceLocator {

    @Inject
    private DataService dataService;
    @Inject
    private ITaskService taskService;
    @Inject
    private IProjectService projectService;
    @Inject
    private IUserService userService;
    @Inject
    private ISessionService sessionService;
    @Inject
    private TaskEndpoint taskEndpoint;
    @Inject
    private ProjectEndpoint projectEndpoint;
    @Inject
    private UserEndpoint userEndpoint;
    @Inject
    private SessionEndpoint sessionEndpoint;
    @Inject
    private DataEndpoint dataEndpoint;

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
        Endpoint.publish("http://" + host + ":" + port + "/" + taskEndpoint.getClass().getSimpleName() + "?wsdl", taskEndpoint);
        Endpoint.publish("http://" + host + ":" + port + "/" + projectEndpoint.getClass().getSimpleName() + "?wsdl", projectEndpoint);
        Endpoint.publish("http://" + host + ":" + port + "/" + userEndpoint.getClass().getSimpleName() + "?wsdl", userEndpoint);
        Endpoint.publish("http://" + host + ":" + port + "/" + sessionEndpoint.getClass().getSimpleName() + "?wsdl", sessionEndpoint);
        Endpoint.publish("http://" + host + ":" + port + "/" + dataEndpoint.getClass().getSimpleName() + "?wsdl", dataEndpoint);
    }
}