package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.User;

import java.util.List;

public class UserLoginCommand extends AbstractCommand {

    private final boolean secure = true;

    @Override
    public void execute() {
        System.out.println("Please enter login :");
        String login = getBootstrap().readLine();
        if (login == null){
            System.out.println("Empty field, authorization failed!");
            return;
        }

        System.out.println("Please enter password :");
        String password = getBootstrap().readLine();
        if (password == null){
            System.out.println("Empty field, authorization failed!");
            return;
        }

        List<User> userList = getBootstrap().getUserEndpointService().userGetAll();
        String passwordHash = String.valueOf(password.hashCode());
        for (User userInList: userList){
            if (userInList.getLogin().equals(login) && userInList.getPassword().equals(passwordHash) ){
                getBootstrap().setActiveUser(userInList);
                System.out.println("You are logged in as " + userInList.getLogin());
                return;
            }
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
