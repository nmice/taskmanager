package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Task;

public class TaskListCommand extends AbstractCommand {

    @Override
    public void execute() {
        for (Task task : getBootstrap().getTaskService().getAll()) {
            System.out.println(task);
        }
    }

    @Override
    public String command() {
        return "tasklist";
    }

    @Override
    public String description() {
        return "Get task list";
    }
}
