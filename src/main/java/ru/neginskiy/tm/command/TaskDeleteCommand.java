package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Task;

import java.util.List;

public class TaskDeleteCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("Please select task number to remove :");
        List<Task> taskList = getBootstrap().getTaskService().getAll();
        int indexOfProject = 0;
        for (Task task : taskList) {
            System.out.printf("%-3s%s%s%n", indexOfProject++, " - ", task.getName());
        }
        int number;
        String id;
        try {
            number = Integer.parseInt(getBootstrap().readLine());
            Task task = taskList.get(number);
            if (task == null) {
                System.out.println("Incorrect input, task not found");
                return;
            }
            id = task.getId();
        } catch (Exception e) {
            System.out.println("Incorrect input, task not found");
            return;
        }
        getBootstrap().getTaskService().delete(id);
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
}
