package ru.neginskiy.tm.api;

import ru.neginskiy.tm.entity.AbstractEntity;

import java.util.List;

public interface IRepository<T extends AbstractEntity> {

    void merge(T entity);

    T getById(String id);

    List<T> getAll();

    void delete(T entity);
}
