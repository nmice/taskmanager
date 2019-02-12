package ru.neginskiy.tm.api.service;

import ru.neginskiy.tm.entity.Task;

import java.util.List;

public interface ITaskService {

    void merge(Task task);

    Task getById(String id);

    List<Task> getAllByUserId(String userId);

    Task delete(String id);

}