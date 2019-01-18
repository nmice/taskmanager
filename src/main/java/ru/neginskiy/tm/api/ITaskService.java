package ru.neginskiy.tm.api;

import ru.neginskiy.tm.entity.Task;

import java.util.List;

public interface ITaskService {

    void merge(Task task);

    Task getById(String id);

    List<Task> getAll();

    Task delete(String id);
    
}