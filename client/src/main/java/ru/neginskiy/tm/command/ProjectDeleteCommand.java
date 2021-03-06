package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.Project;

import java.util.List;

public class ProjectDeleteCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        List<Project> projectList = getBootstrap().getProjectEndpointService().projectGetAll();
        if (projectList.size() == 0) {
            System.out.println("Projects not found");
            return;
        }

        System.out.println("Please select project number to remove :");
        int indexOfProject = 0;
        for (Project project : projectList) {
            System.out.printf("%-3s%s%s%n", indexOfProject++, " - ", project.getName());
        }

        Project project;
        try {
            int projectNumber = Integer.parseInt(getBootstrap().readLine());
            project = projectList.get(projectNumber);
            if (project == null) {
                System.out.println("Incorrect input, project not found");
                return;
            }
        } catch (Exception e) {
            System.out.println("Incorrect input, project not found");
            return;
        }

        String id = project.getId();

        System.out.println("Project deleted");
    }

    @Override
    public String command() {
        return "projectdelete";
    }

    @Override
    public String description() {
        return "Delete project";
    }

    @Override
    public boolean isSecure() {
        return secure;
    }
}
