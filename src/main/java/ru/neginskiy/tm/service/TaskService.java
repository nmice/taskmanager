package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;

import java.util.Date;
import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void merge(Task task) {
        taskRepository.merge(task);
    }

    public Task getById(String id) {
        return taskRepository.getById(id);
    }

    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    public void updateName(String id, String name) {
        taskRepository.updateName(id, name);
    }

    public void updateDescription(String id, String Description) {
        taskRepository.updateDescription(id, Description);
    }

    public void updateEndDate(String id, Date dateEnd) {
        taskRepository.updateEndDate(id, dateEnd);
    }

    public void delete(String id) {
        taskRepository.delete(id);
    }

    public void deleteByProjectId(String id) {
        taskRepository.deleteByProjectId(id);
    }
    //TODO !null
}
