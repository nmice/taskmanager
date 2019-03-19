package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.User;

@Repository
public interface IUserRepository extends FullEntityRepository<User, String> {

    @Query("FROM User u where u.login = ?1 and u.password = ?2")
    @Nullable User findUser(@NotNull String login, @NotNull String password);

    @Query("FROM User u where u.login = ?1")
    @Nullable User getByLogin(@NotNull String login);
}
