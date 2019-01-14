package ru.neginskiy.tm.service;

import ru.neginskiy.tm.repository.TaskRepository;

public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository projectRepository) {
        this.taskRepository = projectRepository;
    }

    //TODO TRcode + TR obj + !null
}
