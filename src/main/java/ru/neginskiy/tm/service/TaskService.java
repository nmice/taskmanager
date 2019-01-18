package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;

public class TaskService extends AbstractService<Task, TaskRepository>{

    private final TaskRepository entityRepository;

    public TaskService(TaskRepository entityRepository) {
        this.entityRepository = entityRepository;
    }
}
