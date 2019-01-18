package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;

import java.util.List;

public class ProjectListCommand extends AbstractCommand {

    @Override
    public void execute() {
        List<Project> projectList = getBootstrap().getProjectService().getAll();
        if (projectList.size() == 0) {
            System.out.println("Projects not found");
            return;
        }
        for (Project project : projectList) {
            System.out.println(project);
        }
    }

    @Override
    public String command() {
        return "projectlist";
    }

    @Override
    public String description() {
        return "Get project list";
    }
}
