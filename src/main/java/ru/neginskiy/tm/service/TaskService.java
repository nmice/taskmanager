package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private final TaskRepository entityRepository;

    public TaskService(TaskRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public void merge(Task task) {
        if (task == null) {
            return;
        }
        entityRepository.merge(task);
    }

    public Task getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.getById(id);
    }

    public List<Task> getAll() {
        return entityRepository.getAll();
    }

    public void delete(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        entityRepository.delete(id);
    }
}
