package ru.neginskiy.tm.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ru.neginskiy.tm.repository.ProjectRepository.*;

public class ProjectEditCommand extends AbstractCommand {

    @Override
    public void execute() {
/*        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter project ID number to update: ");
        int projectId = scanner.nextInt();
        System.out.println(getProjectById(projectId));
        System.out.println("Enter the command: \r\n" +
                "changename - change name of Project \r\n" +
                "changedescription - change description of Project \r\n" +
                "changeenddate - change a end date of Project");
        String updateCommand = scanner.nextLine().toLowerCase().trim();

        if (updateCommand.equals("changename")){
            System.out.println("Please enter a new project name: ");
            String projectName = scanner.nextLine();
            updateProjectName(projectId, projectName);
        }
        if (updateCommand.equals("changedescription")){
            System.out.println("Please enter a new project description: ");
            String projectDescription = scanner.nextLine();
            updateProjectDescription(projectId, projectDescription);
        }
        if (updateCommand.equals("changeenddate")){
            System.out.println("Please enter a new project end date: ");
            String projectEndDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            updateProjectEndDate(projectId, LocalDate.parse(projectEndDate, formatter));
        }*///TODO
    }

    @Override
    public String command() {
        return "projectedit";
    }

    @Override
    public String description() {
        return " - Edit project";
    }
}
