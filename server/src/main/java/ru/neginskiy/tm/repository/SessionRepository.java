package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ISessionRepository;
import ru.neginskiy.tm.entity.Session;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SessionRepository extends AbstractRepository<Session> implements ISessionRepository {

    @Override
    public @NotNull List<Session> getAllByUserId(@NotNull String userId) {
        return entityManager
                .createQuery("from Session s where s.user.id=:paramUserId", Session.class)
                .setParameter("paramUserId", userId)
                .getResultList();
    }

    @Override
    public @Nullable Session getById(@NotNull String id) {
        return entityManager.find(Session.class, id);
    }
}