package ru.neginskiy.tm.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ru.neginskiy.tm.repository.ProjectRepository.createProject;
import static ru.neginskiy.tm.repository.ProjectRepository.getNewId;


public class CreateProjectCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name of the project :");
        String name = scanner.nextLine();
        System.out.println("Please enter a description of the project :");
        String description = scanner.nextLine();
        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        String dateBegin = scanner.nextLine();
        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        String dateEnd = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        createProject(name, description, LocalDate.parse(dateBegin, formatter), LocalDate.parse(dateEnd, formatter), getNewId());
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
