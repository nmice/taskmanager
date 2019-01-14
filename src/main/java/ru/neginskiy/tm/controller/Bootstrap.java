package ru.neginskiy.tm.controller;

import ru.neginskiy.tm.command.AbstractCommand;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.TaskRepository;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    Map<String, AbstractCommand> stringToCommand = new HashMap<>();
        stringToCommand.put("ct", new CreateTaskCommand());
        stringToCommand.put("rt", new TaskListCommand());
        stringToCommand.put("ut", new EditTaskCommand());
        stringToCommand.put("dt", new DeleteTaskCommand());
        stringToCommand.put("cp", new CreateProjectCommand());
        stringToCommand.put("rp", new ProjectListCommand());
        stringToCommand.put("up", new EditProjectCommand());
        stringToCommand.put("dp", new DeleteProjectCommand());//to BT

    ProjectRepository projectRepository = new ProjectRepository();//toBT
    TaskRepository taskRepository = new TaskRepository();//BT
}
