package ru.neginskiy.tm.command;

import java.util.Scanner;

public class ProjectDeleteCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter project ID number to remove: ");
        int projectId = scanner.nextInt();
        //deleteProject(projectId);//TODO
    }

    @Override
    public String command() {
        return "projectdelete";
    }

    @Override
    public String description() {
        return " - Delete task";
    }
}
