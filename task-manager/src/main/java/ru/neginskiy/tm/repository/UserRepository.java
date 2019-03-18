package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@ApplicationScoped
public class UserRepository extends AbstractRepository<User> {

    @Override
    public @Nullable User getById(@NotNull String id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public @NotNull List<User> getAll() {
        return entityManager
                .createQuery("from User u", User.class)
                .getResultList();
    }

    public boolean isRegistredLogin(@Nullable String login) {
        return entityManager
                .createQuery("from User u where u.login=:paramLogin", User.class)
                .setParameter("paramLogin", login)
                .getSingleResult() != null;
    }

    public @Nullable User findUser(@NotNull String login, @NotNull String password) {
        return entityManager
                .createQuery("from User u where u.login=:paramLogin and u.password=:paramPassword", User.class)
                .setParameter("paramLogin", login)
                .setParameter("paramPassword", password)
                .getSingleResult();
    }
}
