package ru.neginskiy.tm.command;

import static ru.neginskiy.tm.repository.TaskRepository.getAllTasks;

public class TaskListCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println(getAllTasks());
    }

    @Override
    public String command() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}
