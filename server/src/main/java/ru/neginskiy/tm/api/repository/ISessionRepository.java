package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Session;

import javax.persistence.EntityTransaction;
import java.util.List;

public interface ISessionRepository {

    @NotNull List<Session> getAllByUserId(@NotNull String userId);

    @Nullable Session getById(@NotNull String id);

    void merge(@NotNull Session session);

    void delete(@NotNull Session session);

    void close();

    EntityTransaction getTransaction();
}
