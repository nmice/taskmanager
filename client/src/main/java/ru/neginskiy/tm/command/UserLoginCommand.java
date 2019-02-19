package ru.neginskiy.tm.command;


import ru.neginskiy.tm.endpoint.Session;
import ru.neginskiy.tm.endpoint.User;

import javax.persistence.NoResultException;

public class UserLoginCommand extends AbstractCommand {

    private final boolean secure = true;

    @Override
    public void execute(){
        System.out.println("Please enter login :");
        final String login = getBootstrap().readLine();
        if (login == null) {
            System.out.println("Empty field, authorization failed!");
            return;
        }
        if (!getBootstrap().getUserEndpointService().isRegistredLogin(login)) {
            System.out.println("This login is not registered, authorization failed!");
            return;
        }

        System.out.println("Please enter password :");
        final String password = getBootstrap().readLine();
        if (password == null) {
            System.out.println("Empty field, authorization failed!");
            return;
        }
        final String passwordHash = String.valueOf(password.hashCode());
        final User user = getBootstrap().getUserEndpointService().findUser(login, passwordHash);
        if (user != null) {
            Session session = getBootstrap().getSessionEndpointService().getNewSession(user);
            getBootstrap().setActiveSession(session);
            System.out.println("You are logged in as " + user.getLogin());
            return;
        }
        System.out.println("User not found, authorization failed!");
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
