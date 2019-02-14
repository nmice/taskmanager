package ru.neginskiy.tm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.entity.User;

public class UserRepository implements IUserRepository {

    private final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public @Nullable User findUser(@NotNull String login, @NotNull String passwordHash) {
        User user = (User) sessionFactory.openSession().createQuery("from task where login='login' and passwordHash='passwordHash'");
        return user;
    }

    @Override
    public @Nullable User getById(@NotNull String id) {
        return sessionFactory.openSession().get(User.class, id);
    }

    @Override
    public void merge(@NotNull User user) {
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        hibernateSession.saveOrUpdate(user);
        transaction.commit();
        hibernateSession.close();
    }

    @Override
    public void delete(@NotNull User user) {
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        hibernateSession.delete(user);
        transaction.commit();
        hibernateSession.close();
    }

    @Override
    public @Nullable User getByLogin(@NotNull String login) {
        User user = (User) sessionFactory.openSession().createQuery("from user where login='login'");
        return user;
    }
}