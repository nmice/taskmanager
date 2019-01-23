package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {

    public User findUser(String login, String passwordHash) {
        List<User> userList = new ArrayList<>(entityBase.values());
        for (User userInList : userList) {
            if (userInList.getLogin().equals(login) && userInList.getPassword().equals(passwordHash)) {
                return userInList;
            }
        }
        return null;
    }

    public boolean isRegistredLogin(String login) {
        List<User> userList = new ArrayList<>(entityBase.values());
        for (User userInList : userList) {
            if (userInList.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

}
