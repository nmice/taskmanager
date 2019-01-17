package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;

import java.util.List;

public class ProjectDeleteCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("Please select project number to remove :");
        List<Project> projectList = getBootstrap().getProjectService().getAll();
        int indexOfProject = 0;
        for (Project project : projectList) {
            System.out.printf("%-3s%s%s%n", indexOfProject++, " - ", project.getName());
        }
        int projectNumber;
        String id;
        try {
            projectNumber = Integer.parseInt(getBootstrap().readLine());
            Project project = projectList.get(projectNumber);
            if (project == null) {
                System.out.println("Incorrect input, project not found");
                return;
            }
            id = project.getId();
        } catch (Exception e) {
            System.out.println("Incorrect input, project not found");
            return;
        }

        getBootstrap().getProjectService().delete(id);
        getBootstrap().getTaskService().deleteByProjectId(id);

        System.out.println("Project and nested tasks deleted");
    }

    @Override
    public String command() {
        return "projectdelete";
    }

    @Override
    public String description() {
        return "Delete project";
    }
}
