package ru.neginskiy.tm.api.repository;

import ru.neginskiy.tm.entity.AbstractEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public interface IRepository<T extends AbstractEntity> {

    List<T> getAllByUserId(String userId);

    T getById(String id);

    void merge(T entity);

    void delete(T entity);

    void close();

    EntityTransaction getTransaction();
}
