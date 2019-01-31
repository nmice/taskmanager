package ru.neginskiy.tm.command;

public class UserLogoutCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        getBootstrap().getSessionEndpointService().sessionDelete(getBootstrap().getActiveSession().getId());
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
