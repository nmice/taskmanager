package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.api.repository.IRepository;
import ru.neginskiy.tm.entity.AbstractEntity;

import java.util.*;

public abstract class AbstractRepository<T extends AbstractEntity> implements IRepository<T> {

    public abstract void merge(T entity);

    public abstract T getById(String id);

    public abstract List<T> getAll();

    public abstract T delete(String id);
}