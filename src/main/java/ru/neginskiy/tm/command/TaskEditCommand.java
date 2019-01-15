package ru.neginskiy.tm.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskEditCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter task ID to update: ");
        String id = scanner.nextLine();
        System.out.println(getBootstrap().getTaskService().getTaskById(id));
        System.out.println("Enter the command: \r\n" +
                "changename        - change name of Task \r\n" +
                "changedescription - change description of Task \r\n" +
                "changeenddate     - change a end date of Task");
        String updateCommandString = scanner.nextLine().toLowerCase().trim();
        switch (updateCommandString) {
            case "changename":
                System.out.println("Please enter a new project name: ");
                String name = scanner.nextLine();
                getBootstrap().getTaskService().updateTaskName(id, name);
            case "changedescription":
                System.out.println("Please enter a new project description: ");
                String projectDescription = scanner.nextLine();
                getBootstrap().getTaskService().updateTaskDescription(id, projectDescription);
            case "changeenddate":
                System.out.println("Please enter a new project end date: ");
                String projectEndDate = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                getBootstrap().getTaskService().updateTaskEndDate(id, LocalDate.parse(projectEndDate, formatter));
        }
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
