package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserRepository extends AbstractRepository<User> {

    public @Nullable User findUser(@NotNull String login, @NotNull String password) {
        List<User> userList = getAll();
        for (User userInList : userList) {
            if (userInList.getLogin().equals(login) && userInList.getPassword().equals(password)) {
                return userInList;
            }
        }
        return null;
    }

    public boolean isRegistredLogin(@Nullable String login) {
        if (login == null) return false;
        List<User> userList = getAll();
        for (User userInList : userList) {
            if (userInList.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
