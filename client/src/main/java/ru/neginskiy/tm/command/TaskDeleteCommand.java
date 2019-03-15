package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.Task;

import java.util.List;

public class TaskDeleteCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        List<Task> taskList = getBootstrap().getTaskEndpointService().taskGetAll();
        if (taskList.size() == 0) {
            System.out.println("Tasks not found");
            return;
        }

        System.out.println("Please select task number to remove :");
        int indexOfTask = 0;
        for (Task task : taskList) {
            System.out.printf("%-3s%s%s%n", indexOfTask++, " - ", task.getName());
        }

        Task task;
        try {
            int taskNumber = Integer.parseInt(getBootstrap().readLine());
            task = taskList.get(taskNumber);
            if (task == null) {
                System.out.println("Incorrect input, task not found");
                return;
            }
        } catch (Exception e) {
            System.out.println("Incorrect input, task not found");
            return;
        }
        getBootstrap().getTaskEndpointService().taskDelete(task.getId());
        System.out.println("Task deleted");
    }

    @Override
    public String command() {
        return "taskdelete";
    }

    @Override
    public String description() {
        return "Delete task";
    }

    @Override
    public boolean isSecure() {
        return secure;
    }
}
