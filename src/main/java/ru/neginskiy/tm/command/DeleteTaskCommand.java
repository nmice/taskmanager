package ru.neginskiy.tm.command;

import java.util.Scanner;

import static ru.neginskiy.tm.repository.TaskRepository.deleteTask;

public class DeleteTaskCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter project ID number to remove: ");
        int taskId = scanner.nextInt();
        deleteTask(taskId);
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
