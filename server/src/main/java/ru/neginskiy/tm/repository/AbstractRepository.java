package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IRepository;
import ru.neginskiy.tm.entity.AbstractEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class AbstractRepository<T extends AbstractEntity> implements IRepository<T> {

    @Inject
    EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void close() {
        entityManager.close();
    }

    @Override
    public @NotNull EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }

    @Override
    public abstract @Nullable T getById(@NotNull String id);

    @Override
    public void merge(@NotNull T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(@NotNull T entity) {
        entityManager.remove(entity);
    }
}