package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public class UserLogoutCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        try {
            getBootstrap().getSessionEndpointService().sessionDelete(getBootstrap().getActiveSession());
        } catch (UncorrectSessionException_Exception e) {
            getBootstrap().setActiveUser(null);
            System.out.println("Uncorrect session, please log in");
            return;
        }
        getBootstrap().setActiveUser(null);
        System.out.println("You are logout");
    }

    @Override
    public String command() {
        return "logout";
    }

    @Override
    public String description() {
        return "Log out";
    }

    @Override
    public boolean isSecure() {
        return secure;
    }
}
