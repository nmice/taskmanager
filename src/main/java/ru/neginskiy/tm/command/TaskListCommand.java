package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Task;

public class TaskListCommand extends AbstractCommand {

    @Override
    public void execute() {
        for (Task task: getBootstrap().getTaskService().getAllTasks()){
            System.out.println(task);
        }
//        getBootstrap().getTaskService().getAllTasks().forEach(System.out::println);
    }

    @Override
    public String command() {
        return "tasklist";
    }

    @Override
    public String description() {
        return " - Get task list";
    }
}