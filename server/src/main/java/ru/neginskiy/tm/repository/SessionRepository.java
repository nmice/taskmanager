package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ISessionRepository;
import ru.neginskiy.tm.entity.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class SessionRepository implements ISessionRepository {

    private final EntityManagerFactory entityManagerFactory;

    public SessionRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public @NotNull List<Session> getAllByUserId(@NotNull String userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Session> sessionList = entityManager
                .createQuery("from Session s where s.user.id=:paramUserId", Session.class)
                .setParameter("paramUserId", userId)
                .getResultList();
        entityManager.close();
        return sessionList;
    }

    @Override
    public @Nullable Session getById(@NotNull String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.find(Session.class, id);
        entityManager.close();
        return session;
    }

    @Override
    public void merge(@NotNull Session session) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(session);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(@NotNull Session session) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(session);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}