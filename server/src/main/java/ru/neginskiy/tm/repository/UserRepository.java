package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserRepository implements IUserRepository {

    private final EntityManagerFactory entityManagerFactory;

    public UserRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public @Nullable User findUser(@NotNull String login, @NotNull String passwordHash) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> userList = entityManager
                .createQuery("from User u where u.login=:paramLogin and u.passwordHash=:paramPasswordHash", User.class)
                .setParameter("paramLogin", login)
                .setParameter("paramPasswordHash", passwordHash)
                .getResultList();
        entityManager.close();
        return userList.get(0);
    }

    @Override
    public @Nullable User getById(@NotNull String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    @Override
    public void merge(@NotNull User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(@NotNull User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public @Nullable User getByLogin(@NotNull String login) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> userList = entityManager
                .createQuery("from User u where u.login=:paramLogin", User.class)
                .setParameter("paramLogin", login)
                .getResultList();
        entityManager.close();
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }
}