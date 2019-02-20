package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.api.repository.IRepository;
import ru.neginskiy.tm.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.*;

public abstract class AbstractRepository<T extends AbstractEntity> implements IRepository<T> {

    EntityManager entityManager;

    @Override
    public void close() {
        entityManager.close();
    }

    @Override
    public EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }

    @Override
    public abstract T getById(String id);

    @Override
    public abstract List<T> getAllByUserId(String userId);

    @Override
    public void merge(@NotNull T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(@NotNull T entity) {
        entityManager.remove(entity);
    }
}