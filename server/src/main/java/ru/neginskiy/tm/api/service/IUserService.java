package ru.neginskiy.tm.api.service;

import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.User;

public interface IUserService {

    void merge(@Nullable User user);

    @Nullable User getById(@Nullable String id);

    @Nullable User findUser(@Nullable String login, @Nullable String passwordHash);

    boolean isRegistredLogin(@Nullable String login);
}