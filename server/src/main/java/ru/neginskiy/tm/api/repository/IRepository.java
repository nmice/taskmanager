package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public interface IRepository<T extends AbstractEntity> {

    void setEntityManager(EntityManager entityManager);

    void close();

    EntityTransaction getTransaction();

    @Nullable T getById(@NotNull String id);

    void merge(@NotNull T entity);

    void delete(@NotNull T entity);
}
