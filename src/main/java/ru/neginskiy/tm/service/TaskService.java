package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void merge(Task task) {
        if (task == null) {
            return;
        }
        taskRepository.merge(task);
    }

    public Task getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return taskRepository.getById(id);
    }

    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    public void delete(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        taskRepository.delete(id);
    }

    public void deleteByProjectId(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        taskRepository.deleteByProjectId(id);
    }
    //
}
