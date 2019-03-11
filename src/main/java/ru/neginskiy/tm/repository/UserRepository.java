package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.User;

import java.util.List;

public class UserRepository extends AbstractRepository<User> {

    private static UserRepository instance;

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            User demoUser = new User();
            demoUser.setId("UID");
            demoUser.setLogin("test");
            demoUser.setPassword("test");
            instance = new UserRepository();
            instance.merge(demoUser);
            return instance;
        }
        return instance;
    }

    public @Nullable User findUser(@NotNull String login, @NotNull String password) {
        List<User> userList = getAll();
        for (User userInList : userList) {
            if (userInList.getLogin().equals(login) && userInList.getPassword().equals(password)) {
                return userInList;
            }
        }
        return null;
    }

    public @Nullable boolean isRegistredLogin(@NotNull String login) {
        List<User> userList = getAll();
        for (User userInList : userList) {
            if (userInList.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
