package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.entity.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository extends AbstractRepository<User> implements IUserRepository {

    @Override
    public @Nullable User getById(@NotNull String id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public @Nullable User findUser(@NotNull String login, @NotNull String passwordHash) {
        return entityManager
                .createQuery("from User u where u.login=:paramLogin and u.passwordHash=:paramPasswordHash", User.class)
                .setParameter("paramLogin", login)
                .setParameter("paramPasswordHash", passwordHash)
                .getSingleResult();
    }

    @Override
    public @Nullable User getByLogin(@NotNull String login) {
        return entityManager
                .createQuery("from User u where u.login=:paramLogin", User.class)
                .setParameter("paramLogin", login)
                .getSingleResult();
    }
}