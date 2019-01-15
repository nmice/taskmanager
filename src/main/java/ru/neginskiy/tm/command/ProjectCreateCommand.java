package ru.neginskiy.tm.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a name of the project :");
        String name = scanner.nextLine();

        System.out.println("Please enter a description of the project :");
        String description = scanner.nextLine();

        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateBegin = scanner.nextLine();
        try {
            LocalDate.parse(dateBegin, formatter);
        } catch (Exception e) {
            System.out.println("Incorrect date format, please try again");
            System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
            dateBegin = scanner.nextLine();
        }

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        String dateEnd = scanner.nextLine();
        try {
            LocalDate.parse(dateEnd, formatter);
        } catch (Exception e) {
            System.out.println("Incorrect date format, please try again");
            System.out.println("Please enter a end date in the format DD-MM-YYYY :");
            dateEnd = scanner.nextLine();
        }
        getBootstrap().getProjectService().createProject(name, description, LocalDate.parse(dateBegin, formatter), LocalDate.parse(dateEnd, formatter));
    }

    @Override
    public String command() {
        return "projectcreate";
    }

    @Override
    public String description() {
        return " - Create a new project";
    }
}
