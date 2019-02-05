package ru.neginskiy.tm.command;

public class ExitCommand extends AbstractCommand {

    private final boolean secure = true;

    @Override
    public void execute() {
        getBootstrap().getSessionEndpointService().sessionDelete(getBootstrap().getActiveSession());
        System.exit(0);
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
