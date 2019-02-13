package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.Project;
import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

import java.util.List;

public class ProjectDeleteCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() throws UncorrectSessionException_Exception {
        final List<Project> projectList = getBootstrap().getProjectEndpointService().projectGetAllByUserId(
                getBootstrap().getActiveSession(), getBootstrap().getActiveSession().getUserId());
        if (projectList.size() == 0) {
            System.out.println("Projects not found");
            return;
        }
        System.out.println("Please select project number to remove :");
        int indexOfProject = 0;
        for (Project project : projectList) {
            System.out.printf("%-3s%s%s%n", indexOfProject++, " - ", project.getName());
        }
        final Project project;
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
        getBootstrap().getProjectEndpointService().projectDelete(getBootstrap().getActiveSession(), project.getId());
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
