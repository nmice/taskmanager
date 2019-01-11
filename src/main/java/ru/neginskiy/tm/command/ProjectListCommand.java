package ru.neginskiy.tm.command;

import static ru.neginskiy.tm.repository.ProjectRepository.getAllProjects;

public class ProjectListCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println(getAllProjects());
    }

    @Override
    public String command() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}
