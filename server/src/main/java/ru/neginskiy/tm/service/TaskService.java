package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;
import ru.neginskiy.tm.api.ITaskService;

import java.util.List;

public class TaskService implements ITaskService {

    private final TaskRepository entityRepository;

    public TaskService(TaskRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public void merge(Task task) {
        if (task == null) {
            return;
        }
        entityRepository.merge(task);
    }

    @Override
    public Task getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.getById(id);
    }

    @Override
    public List<Task> getAllByUserId(String userId) {
        if (userId == null || userId.isEmpty()) {
            return null;
        }
        return entityRepository.getAllByUserId(userId);
    }

    @Override
    public Task delete(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.delete(id);
    }


}
