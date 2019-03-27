package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.neginskiy.tm.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    @Query("select u FROM User u where u.login = :login and u.passwordHash = :passwordHash")
    @Nullable User findUser(@NotNull @Param("login") String login, @NotNull @Param("passwordHash") String passwordHash);

    @Query("select u FROM User u where u.login = :login")
    @Nullable User getByLogin(@NotNull @Param("login") String login);
}