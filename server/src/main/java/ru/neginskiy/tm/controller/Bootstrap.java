package ru.neginskiy.tm.controller;

import ru.neginskiy.tm.endpoint.ProjectEndpoint;
import ru.neginskiy.tm.endpoint.SessionEndpoint;
import ru.neginskiy.tm.endpoint.TaskEndpoint;
import ru.neginskiy.tm.endpoint.UserEndpoint;
import ru.neginskiy.tm.repository.SessionRepository;
import ru.neginskiy.tm.repository.TaskRepository;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.UserRepository;
import ru.neginskiy.tm.service.ProjectService;
import ru.neginskiy.tm.service.SessionService;
import ru.neginskiy.tm.service.TaskService;
import ru.neginskiy.tm.service.UserService;

import javax.xml.ws.Endpoint;

public class Bootstrap {

    private static final String SECRET_KEY = "taskmanager3000";

    private final TaskService taskService = new TaskService(new TaskRepository());
    private final ProjectService projectService = new ProjectService(new ProjectRepository());
    private final UserService userService = new UserService(new UserRepository());
    private final SessionService sessionService = new SessionService(new SessionRepository());
    private User activeUser;

    public void init() {
        registryInNet();
        /*if (userService.getAllByUserId().size() == 0) {
            createTestUser();
        }*/
    }

 /*   private void createTestUser() {
        User testUser = new User();
        testUser.setLogin("test");
        testUser.setPassword(String.valueOf(("test").hashCode()));
        getUserService().merge(testUser);
    }*/

    private void registryInNet() {
        Endpoint.publish("http://localhost:8080/TaskEndpoint?wsdl", new TaskEndpoint(taskService));
        Endpoint.publish("http://localhost:8080/ProjectEndpoint?wsdl", new ProjectEndpoint(projectService));
        Endpoint.publish("http://localhost:8080/UserEndpoint?wsdl", new UserEndpoint(userService));
        Endpoint.publish("http://localhost:8080/SessionEndpoint?wsdl", new SessionEndpoint(sessionService));
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public UserService getUserService() {
        return userService;
    }

    public SessionService getSessionService() {
        return sessionService;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}