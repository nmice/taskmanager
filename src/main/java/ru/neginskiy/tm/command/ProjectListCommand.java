package ru.neginskiy.tm.command;

public class ProjectListCommand extends AbstractCommand {

    @Override
    public void execute() {
        //System.out.println(getAllProjects());//TODO
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
