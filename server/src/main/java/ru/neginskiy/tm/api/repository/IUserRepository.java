package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.User;

@Repository
public interface IUserRepository extends IRepository<User>{

    @Nullable User findUser(@NotNull String login,@NotNull String passwordHash);

    @Nullable User getByLogin(@NotNull String login);
}
