package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;

public class ProjectListCommand extends AbstractCommand {

    @Override
    public void execute() {
        for (Project project : getBootstrap().getProjectService().getAllProjects()) {
            System.out.println(project);
        }
//        getBootstrap().getProjectService().getAllProjects().forEach(System.out::println);
    }

    @Override
    public String command() {
        return "projectlist";
    }

    @Override
    public String description() {
        return " - Get project list";
    }
}
