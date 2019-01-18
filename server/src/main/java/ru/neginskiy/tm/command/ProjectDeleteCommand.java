package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

public class ProjectDeleteCommand extends AbstractCommand {

    @Override
    public void execute() {
        List<Project> projectList = getBootstrap().getProjectService().getAll();
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
        getBootstrap().getProjectService().delete(id);
        System.out.println("Project deleted");

        List<Task> taskList = getBootstrap().getTaskService().getAll();
        if (taskList.size() == 0) {
            System.out.println("Tasks not found");
            return;
        }
        for (Task task : taskList) {
            if (id.equals(task.getProjectId())) {
                getBootstrap().getProjectService().delete(task.getId());
            }
        }
        System.out.println("Project's tasks deleted");
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