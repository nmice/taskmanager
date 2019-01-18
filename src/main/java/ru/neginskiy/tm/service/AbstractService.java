package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.AbstractEntity;
import ru.neginskiy.tm.repository.AbstractRepository;

import java.util.List;

public abstract class AbstractService<T extends AbstractEntity, R extends AbstractRepository<T>>/* implements IService */{

    R entityRepository;

    public void merge(T t) {
        if (t == null) {
            return;
        }
        entityRepository.merge(t);
    }

    public T getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.getById(id);
    }

    public List<T> getAll() {
        return entityRepository.getAll();
    }

    public T delete(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.delete(id);
    }
}
