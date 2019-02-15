package ru.neginskiy.tm.service;

import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.UserRepository;

public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void merge(@Nullable User user) {
        if (user == null) {
            return;
        }
        userRepository.merge(user);
    }

    @Override
    public @Nullable User getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return userRepository.getById(id);
    }

    @Override
    public @Nullable User findUser(@Nullable String login, @Nullable String passwordHash) {
        if (login == null || passwordHash == null) {
            return null;
        }
        return userRepository.findUser(login, passwordHash);
    }

    @Override
    public boolean isRegistredLogin(@Nullable String login) {
        if (login == null) {
            return true;
        }
        final User user = userRepository.getByLogin(login);
        return user != null;
    }
}