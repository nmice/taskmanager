package ru.neginskiy.tm.command;

public class ExitCommand extends AbstractCommand {

    private final boolean secure = true;

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

    @Override
    public boolean isSecure() {
        return secure;
    }
}
