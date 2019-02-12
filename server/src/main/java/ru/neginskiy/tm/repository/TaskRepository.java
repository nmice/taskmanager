package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.sql.Connection;
import java.util.List;

public class TaskRepository extends AbstractRepository<Task> {

    public TaskRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void merge(Task entity) {

    }

    @Override
    public Task getById(String id) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task delete(String id) {
        return null;
    }
}