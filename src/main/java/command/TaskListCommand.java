package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Task;

import java.util.List;

public class TaskListCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        List<Task> taskList = getBootstrap().getTaskService().getAll();
        if (taskList.size() == 0) {
            System.out.println("Tasks not found");
            return;
        }
        for (Task task : taskList) {
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

    @Override
    public boolean isSecure() {
        return secure;
    }
}
