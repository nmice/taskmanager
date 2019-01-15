package ru.neginskiy.tm.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name of the task :");
        String name = scanner.nextLine();
        System.out.println("Please enter a description of the task :");
        String description = scanner.nextLine();
        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        String dateBegin = scanner.nextLine();
        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        String dateEnd = scanner.nextLine();
        System.out.println("Please enter project ID :");
        String projectID = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        getBootstrap().getTaskService().createTask(name, description, LocalDate.parse(dateBegin, formatter), LocalDate.parse(dateEnd, formatter), projectID);
    }

    @Override
    public String command() {
        return "taskcreate";
    }

    @Override
    public String description() {
        return " - Create a new task";
    }
}
