package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.User;

public class UserLoginCommand extends AbstractCommand {

    private final boolean secure = true;

    @Override
    public void execute() {
        System.out.println("Please enter login :");
        String login = getBootstrap().readLine();
        if (login == null) {
            System.out.println("Empty field, authorization failed!");
            return;
        }

        System.out.println("Please enter password :");
        String password = getBootstrap().readLine();
        if (password == null) {
            System.out.println("Empty field, authorization failed!");
            return;
        }

        User user = getBootstrap().getUserEndpointService().findUser(login, password);
        if (user != null) {
            getBootstrap().setActiveUser(user);
            System.out.println("You are logged in as " + user.getLogin());
            return;
        }
        System.out.println("User not found");
    }

    @Override
    public String command() {
        return "login";
    }

    @Override
    public String description() {
        return "Log in";
    }

    @Override
    public boolean isSecure() {
        return secure;
    }
}
