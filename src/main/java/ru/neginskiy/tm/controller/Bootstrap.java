package ru.neginskiy.tm.controller;

import ru.neginskiy.tm.command.AbstractCommand;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.TaskRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {

    private final Map<String, AbstractCommand> stringToCommand = new HashMap<>();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final TaskRepository taskRepository = new TaskRepository();

    public void init(Class[] classes) throws IllegalAccessException, InstantiationException {
        registry(classes);
        while (true) {
            receiveCommand();
        }
    }

    private void registry(Class... classes) throws InstantiationException, IllegalAccessException {
        for (Class clazz : classes) {
            registry(clazz);
        }
    }

    public void registry(Class clazz) throws IllegalAccessException, InstantiationException {
        final Object o = clazz.newInstance();
        if (o instanceof AbstractCommand){
            final AbstractCommand abstractCommand = (AbstractCommand) clazz.newInstance();
            abstractCommand.setBootstrap(this);
            stringToCommand.put(abstractCommand.command(), abstractCommand);
        }
    }

    private void receiveCommand(){
        System.out.println("Enter command: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase().trim();
        try {
            AbstractCommand command = stringToCommand.get(text);
            command.execute();
        } catch (Exception e) {
            System.out.println("Incorrect command, try again...");
        }
    }

    public Map<String, AbstractCommand> getStringToCommand() {
        return stringToCommand;
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }
}