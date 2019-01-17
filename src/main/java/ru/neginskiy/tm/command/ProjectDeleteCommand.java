package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;

import java.util.Scanner;

public class ProjectDeleteCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter project ID to remove: ");
        String projectId = scanner.nextLine();
        Project project = getBootstrap().getProjectService().delete(projectId);
        if(project == null){
            System.out.println("Project not found");
            return;
        }
        getBootstrap().getTaskService().deleteByProjectId(projectId);
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
