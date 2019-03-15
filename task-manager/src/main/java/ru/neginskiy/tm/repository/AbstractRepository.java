package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.api.IRepository;
import ru.neginskiy.tm.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository<T extends AbstractEntity> implements IRepository<T> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void merge(@NotNull T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(@NotNull T entity) {
        entityManager.remove(entity);
    }
}
