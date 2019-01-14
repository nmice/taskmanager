package ru.neginskiy.tm.command;

public class TaskListCommand extends AbstractCommand {

    @Override
    public void execute() {
        //System.out.println(getAllTasks());//TODO
    }

    @Override
    public String command() {
        return "tasklist";
    }

    @Override
    public String description() {
        return " - Get task list";
    }
}
