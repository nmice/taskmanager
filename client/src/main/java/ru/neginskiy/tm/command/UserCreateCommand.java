package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.User;

import java.util.List;

public class UserCreateCommand extends AbstractCommand {

    private final boolean secure = true;

    @Override
    public void execute() {
        User user = new User();

        System.out.println("Please create a username :");
        String login = getBootstrap().readLine();
        if (login == null) {
            System.out.println("Empty field, no new user created!");
            return;
        }
        List<User> userList = getBootstrap().getUserEndpointService().userGetAll();
        for (User userInList: userList){
            if (userInList.getLogin().equals(login)){
                System.out.println("This login is already registered, no new user created!");
                return;
            }
        }
        user.setLogin(login);

        System.out.println("Please create a password :");
        String password = getBootstrap().readLine();
        if (password == null) {
            System.out.println("Empty field, no new user created!");
            return;
        }
        String passwordHash = String.valueOf(password.hashCode());
        user.setPassword(passwordHash);

        getBootstrap().getUserEndpointService().userMerge(user);
        System.out.println("New user created");
    }

    @Override
    public String command() {
        return "usercreate";
    }

    @Override
    public String description() {
        return "Create a new user";
    }

    @Override
    public boolean isSecure() {
        return secure;
    }
}
