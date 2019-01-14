package ru.neginskiy.tm.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ru.neginskiy.tm.repository.TaskRepository.*;

public class TaskEditCommand extends AbstractCommand {

    @Override
    public void execute() {
/*        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter task ID number to update: ");
        int taskId = scanner.nextInt();
        System.out.println(getTaskById(taskId));
        System.out.println("Enter the command: \r\n" +
                "CN - change name of Task \r\n" +
                "CD - change description of Task \r\n" +
                "CE - change a end date of Task");
        String updateCommand = scanner.nextLine().toLowerCase().trim();

        if (updateCommand.equals("cn")) {
            System.out.println("Please enter a new task name: ");
            String taskName = scanner.nextLine();
            updateTaskName(taskId, taskName);
        }
        if (updateCommand.equals("cd")) {
            System.out.println("Please enter a new task description: ");
            String taskDescription = scanner.nextLine();
            updateTaskDescription(taskId, taskDescription);
        }
        if (updateCommand.equals("ce")) {
            System.out.println("Please enter a new task end date: ");
            String taskEndDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            updateTaskEndDate(taskId, LocalDate.parse(taskEndDate, formatter));
        }*///TODO
    }

    @Override
    public String command() {
        return "taskedit";
    }

    @Override
    public String description() {
        return " - Edit task";
    }
}
