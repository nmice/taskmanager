package ru.neginskiy.tm.command;

public class ExitCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.exit(1);
    }

    @Override
    public String command() {
        return "exit";
    }

    @Override
    public String description() {
        return "Exit program";
    }
}
