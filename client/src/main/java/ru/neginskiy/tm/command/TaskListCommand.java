package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.Task;

import java.util.List;

import static ru.neginskiy.tm.util.GcToStrUtil.getStrFromGc;

public class TaskListCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        List<Task> taskList = getBootstrap().getTaskEndpointService().taskGetAll();
        if (taskList.size() == 0) {
            System.out.println("Tasks not found");
            return;
        }
        for (Task task : taskList) {
            System.out.printf("%s (%s), %s - %s%n", task.getName(), task.getDescription(), getStrFromGc(task.getDateBegin()), getStrFromGc(task.getDateEnd()));
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
