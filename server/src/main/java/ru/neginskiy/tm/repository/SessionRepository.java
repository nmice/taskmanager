package ru.neginskiy.tm.repository;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ISessionRepository;
import ru.neginskiy.tm.entity.Session;

import java.util.List;

public class SessionRepository implements ISessionRepository {

    private final SessionFactory sessionFactory;

    public SessionRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public @NotNull List<Session> getAllByUserId(@NotNull String userId) {
        List<Session> sessionList = (List<Session>) sessionFactory.openSession().createQuery("from session where userId=`userId").list();
        return sessionList;
    }

    @Override
    public @Nullable Session getById(@NotNull String id) {
        return sessionFactory.openSession().get(Session.class, id);
    }

    @Override
    public void merge(@NotNull Session session) {
        org.hibernate.Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        hibernateSession.saveOrUpdate(session);
        transaction.commit();
        hibernateSession.close();
    }

    @Override
    public void delete(@NotNull Session session) {
        org.hibernate.Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        hibernateSession.delete(session);
        transaction.commit();
        hibernateSession.close();
    }
}
