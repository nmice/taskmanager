package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;

import java.util.Date;
import java.util.List;

import static ru.neginskiy.tm.util.StringToDateUtil.getDateFromStr;

public class ProjectEditCommand extends AbstractCommand {

    @Override
    public void execute() {
        Project project;

        System.out.println("Please select project number to update :");
        List<Project> projectList = getBootstrap().getProjectService().getAll();
        int indexOfProject = 0;
        for (Project projectInList : projectList) {
            System.out.printf("%-3s%s%s%n", indexOfProject++, " - ", projectInList.getName());
        }

        int projectNumber;
        try {
            projectNumber = Integer.parseInt(getBootstrap().readLine());
            project = projectList.get(projectNumber);
            System.out.println(project);
            if (project == null) {
                System.out.println("Incorrect input, project not found");
                return;
            }
        } catch (Exception e) {
            System.out.println("Incorrect input, project not found");
            return;
        }

        System.out.println("Enter the command for update: \r\n" +
                "changename        - Change name of project \r\n" +
                "changedescription - Change description of project \r\n" +
                "changeenddate     - Change a end date of project");
        String updateCommandString = getBootstrap().readLine();
        switch (updateCommandString) {
            case "changename":
                System.out.println("Please enter a new project name: ");
                String name = getBootstrap().readLine();
                project.setName(name);
                System.out.println("Name changed");
                break;
            case "changedescription":
                System.out.println("Please enter a new project description: ");
                String description = getBootstrap().readLine();
                project.setDescription(description);
                System.out.println("Description changed");
                break;
            case "changeenddate":
                System.out.println("Please enter a new project end date: ");
                Date dateEnd = getDateFromStr(getBootstrap().readLine());
                Date dateBegin = project.getDateBegin();
                if (dateBegin != null && dateEnd != null && dateEnd.compareTo(dateBegin) < 0) {
                    System.out.println("End date must be later than the begin date, incorrect input");
                    return;
                }
                project.setDateEnd(dateEnd);
                System.out.println("End date changed");
                break;
        }

        getBootstrap().getProjectService().merge(project);
        System.out.println("Project updated");
    }

    @Override
    public String command() {
        return "projectedit";
    }

    @Override
    public String description() {
        return "Edit project";
    }
}
