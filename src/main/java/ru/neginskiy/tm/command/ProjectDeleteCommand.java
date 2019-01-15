package ru.neginskiy.tm.command;

import java.util.Scanner;

public class ProjectDeleteCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter project ID to remove: ");
        String projectId = scanner.nextLine();
        getBootstrap().getProjectService().deleteProject(projectId);
        getBootstrap().getTaskService().deleteTasksByProjectId(projectId);
    }

    @Override
    public String command() {
        return "projectdelete";
    }

    @Override
    public String description() {
        return " - Delete project";
    }
}
