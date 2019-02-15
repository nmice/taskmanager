package ru.neginskiy.tm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.entity.User;

import java.util.List;

public class UserRepository implements IUserRepository {

    private final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public @Nullable User findUser(@NotNull String login, @NotNull String passwordHash) {
        Query query = sessionFactory.openSession().createQuery(
                "from User u where u.login=:paramLogin and u.passwordHash=:paramPasswordHash");
        query.setParameter("paramLogin", login);
        query.setParameter("paramPasswordHash", passwordHash);
        List<User> userList = (List<User>) query.list();
        if (userList.size() == 1) {
            return userList.get(0);
        }
        return null;
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
        Query query = sessionFactory.openSession().createQuery("from User u where u.login=:paramLogin");
        query.setParameter("paramLogin", login);
        List<User> userList = (List<User>) query.list();
        if (userList.size() == 1) {
            return userList.get(0);
        }
        return null;
    }
}