package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.api.IRepository;
import ru.neginskiy.tm.entity.AbstractEntity;

import java.util.*;

public abstract class AbstractRepository<T extends AbstractEntity> implements IRepository<T> {

    private Map<String, T> entityBase = new HashMap<>();

    public void merge(T t) {
        entityBase.put(t.getId(), t);
    }

    public T getById(String id) {
        return entityBase.get(id);
    }

    public List<T> getAll() {
        Collection<T> c = entityBase.values();
        return new ArrayList<>(c);
    }

    public T delete(String id) {
        T project = entityBase.get(id);
        entityBase.remove(id);
        return project;
    }
}
