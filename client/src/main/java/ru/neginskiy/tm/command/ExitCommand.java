package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public class ExitCommand extends AbstractCommand {

    private final boolean secure = true;

    @Override
    public void execute() {
        try {
            getBootstrap().getSessionEndpointService().sessionDelete(getBootstrap().getActiveSession());
        } catch (UncorrectSessionException_Exception e) {
            System.out.println("Uncorrect session, please log in");
        }
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
