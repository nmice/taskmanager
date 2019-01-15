package ru.neginskiy.tm.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProjectEditCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter project ID to update: ");
        String projectId = scanner.nextLine();
        System.out.println(getBootstrap().getProjectService().getProjectById(projectId));
        System.out.println("Enter the command: \r\n" +
                "changename        - change name of Project \r\n" +
                "changedescription - change description of Project \r\n" +
                "changeenddate     - change a end date of Project");
        String updateCommandString = scanner.nextLine().toLowerCase().trim();
        switch (updateCommandString) {
            case "changename":
                System.out.println("Please enter a new project name: ");
                String projectName = scanner.nextLine();
                getBootstrap().getProjectService().updateProjectName(projectId, projectName);
            case "changedescription":
                System.out.println("Please enter a new project description: ");
                String projectDescription = scanner.nextLine();
                getBootstrap().getProjectService().updateProjectDescription(projectId, projectDescription);
            case "changeenddate":
                System.out.println("Please enter a new project end date: ");
                String projectEndDate = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                getBootstrap().getProjectService().updateProjectEndDate(projectId, LocalDate.parse(projectEndDate, formatter));
        }
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
