package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.User;

import javax.persistence.EntityTransaction;

public interface IUserRepository {

    @Nullable User findUser(@NotNull String login,@NotNull String passwordHash);

    @Nullable User getById(@NotNull String id);

    void merge(@NotNull User user);

    void delete(@NotNull User user);

    @Nullable User getByLogin(@NotNull String login);

    void close();

    EntityTransaction getTransaction();
}
