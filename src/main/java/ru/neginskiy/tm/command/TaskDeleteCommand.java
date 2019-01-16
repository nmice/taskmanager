package ru.neginskiy.tm.command;

import java.util.Scanner;

public class TaskDeleteCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter task ID to remove: ");
        String id = scanner.nextLine();
        getBootstrap().getTaskService().deleteTask(id);
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
