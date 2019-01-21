package ru.neginskiy.tm.controller;

import ru.neginskiy.tm.command.AbstractCommand;
import ru.neginskiy.tm.endpoint.ProjectEndpoint;
import ru.neginskiy.tm.endpoint.TaskEndpoint;
import ru.neginskiy.tm.endpoint.UserEndpoint;
import ru.neginskiy.tm.repository.TaskRepository;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.UserRepository;
import ru.neginskiy.tm.service.ProjectService;
import ru.neginskiy.tm.service.TaskService;
import ru.neginskiy.tm.service.UserService;

import javax.xml.ws.Endpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {

    private final Map<String, AbstractCommand> stringToCommand = new HashMap<>();
    private final TaskService taskService = new TaskService(new TaskRepository());
    private final ProjectService projectService = new ProjectService(new ProjectRepository());
    private final UserService userService = new UserService(new UserRepository());

    private User activeUser;

    private final Scanner scanner = new Scanner(System.in);

    public void init(Class[] classes) throws IllegalAccessException, InstantiationException {
        registry(classes);
        registryInNet();
        if (userService.getAll().size() == 0) {
            createTestUser();
        }
        while (true) {
            receiveCommand();
        }
    }

    private void createTestUser() {
        User testUser = new User();
        testUser.setLogin("test");
        testUser.setPassword(String.valueOf(("test").hashCode()));
        getUserService().merge(testUser);
    }

    private void registryInNet() {
        Endpoint.publish("http://localhost:8080/TaskEndpoint", new TaskEndpoint(taskService));
        Endpoint.publish("http://localhost:8080/ProjectEndpoint", new ProjectEndpoint(projectService));
        Endpoint.publish("http://localhost:8080/UserEndpoint", new UserEndpoint(userService));
    }

    private void registry(Class... classes) throws InstantiationException, IllegalAccessException {
        for (Class clazz : classes) {
            registry(clazz);
        }
    }

    private void registry(Class clazz) throws IllegalAccessException, InstantiationException {
        final Object o = clazz.newInstance();
        if (o instanceof AbstractCommand) {
            final AbstractCommand abstractCommand = (AbstractCommand) clazz.newInstance();
            abstractCommand.setBootstrap(this);
            stringToCommand.put(abstractCommand.command(), abstractCommand);
        }
    }

    private void receiveCommand() {
        System.out.println("Enter command: ");
        final String text = readLine();
        if (text == null) {
            return;
        }
        final AbstractCommand command = stringToCommand.get(text);
        if (command == null) {
            System.out.println("Incorrect command");
            return;
        }
        try {
            if (getActiveUser() != null || command.isSecure()) {
                command.execute();
            }
        } catch (Exception ignored) {
        }
    }

    public String readLine() {
        final String str = scanner.nextLine().trim();
        if (str.isEmpty()) {
            System.out.println("Incorrect input");
            return null;
        }
        return str;
    }

    public Map<String, AbstractCommand> getStringToCommand() {
        return stringToCommand;
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

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}