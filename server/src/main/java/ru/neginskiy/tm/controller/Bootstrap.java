package ru.neginskiy.tm.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.neginskiy.tm.api.*;
import ru.neginskiy.tm.api.service.IProjectService;
import ru.neginskiy.tm.api.service.ISessionService;
import ru.neginskiy.tm.api.service.ITaskService;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.endpoint.*;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.service.*;

import javax.xml.ws.Endpoint;

@Getter
@Component
public class Bootstrap implements ServiceLocator {

    @Autowired
    private DataService dataService;
    @Autowired
    private ITaskService taskService;
    @Autowired
    private IProjectService projectService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ISessionService sessionService;
    @Autowired
    private TaskEndpoint taskEndpoint;
    @Autowired
    private ProjectEndpoint projectEndpoint;
    @Autowired
    private UserEndpoint userEndpoint;
    @Autowired
    private SessionEndpoint sessionEndpoint;
    @Autowired
    private DataEndpoint dataEndpoint;

    @Value("${host}")
    private String host;

    @Value("${port}")
    private String port;

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