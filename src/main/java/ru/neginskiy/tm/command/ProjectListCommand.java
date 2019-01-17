package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;

public class ProjectListCommand extends AbstractCommand {

    @Override
    public void execute() {
        for (Project project : getBootstrap().getProjectService().getAll()) {
            System.out.println(project);
        }
//        getBootstrap().getProjectService().getAll().forEach(System.out::println);
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
