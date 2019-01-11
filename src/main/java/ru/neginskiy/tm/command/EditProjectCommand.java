package ru.neginskiy.tm.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ru.neginskiy.tm.repository.ProjectRepository.*;

public class EditProjectCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter project ID number to update: ");
        int projectId = scanner.nextInt();
        System.out.println(getProjectById(projectId));
        System.out.println("Enter the command: \r\n" +
                "CN - change name of Project \r\n" +
                "CD - change description of Project \r\n" +
                "CE - change a end date of Project");
        String updateCommand = scanner.nextLine().toLowerCase().trim();

        if (updateCommand.equals("cn")){
            System.out.println("Please enter a new project name: ");
            String projectName = scanner.nextLine();
            updateProjectName(projectId, projectName);
        }
        if (updateCommand.equals("cd")){
            System.out.println("Please enter a new project description: ");
            String projectDescription = scanner.nextLine();
            updateProjectDescription(projectId, projectDescription);
        }
        if (updateCommand.equals("ce")){
            System.out.println("Please enter a new project end date: ");
            String projectEndDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            updateProjectEndDate(projectId, LocalDate.parse(projectEndDate, formatter));
        }
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
