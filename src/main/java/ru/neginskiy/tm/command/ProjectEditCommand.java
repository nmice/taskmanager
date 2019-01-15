package ru.neginskiy.tm.command;

import ru.neginskiy.tm.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

public class ProjectEditCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter project ID to update: ");
        String id = scanner.nextLine();
        System.out.println(getBootstrap().getProjectService().getProjectById(id));
        System.out.println("Enter the command: \r\n" +
                "changename        - change name of Project \r\n" +
                "changedescription - change description of Project \r\n" +
                "changeenddate     - change a end date of Project");
        String updateCommandString = scanner.nextLine().toLowerCase().trim();
        switch (updateCommandString) {
            case "changename":
                System.out.println("Please enter a new project name: ");
                String projectName = scanner.nextLine();
                getBootstrap().getProjectService().updateProjectName(id, projectName);
            case "changedescription":
                System.out.println("Please enter a new project description: ");
                String projectDescription = scanner.nextLine();
                getBootstrap().getProjectService().updateProjectDescription(id, projectDescription);
            case "changeenddate":
                System.out.println("Please enter a new project end date: ");
                Date dateEnd = DateUtil.getFormattedDateFromKb("new project end date", "dd-MM-yyyy");
                getBootstrap().getProjectService().updateProjectEndDate(id, dateEnd);
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
