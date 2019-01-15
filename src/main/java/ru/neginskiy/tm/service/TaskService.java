package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(String taskName, String taskDescription, LocalDate taskDateBegin, LocalDate taskDateEnd, String projectId) {
        taskRepository.createTask(taskName, taskDescription, taskDateBegin, taskDateEnd, projectId);
    }

    public Task getTaskById(String id) {
        return taskRepository.getTaskById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public void updateTaskName(String taskId, String taskName) {
        taskRepository.updateTaskName(taskId, taskName);
    }

    public void updateTaskDescription(String taskId, String taskDescription) {
        taskRepository.updateTaskDescription(taskId, taskDescription);
    }

    public void updateTaskEndDate(String taskId, LocalDate taskEndDate) {
        taskRepository.updateTaskEndDate(taskId, taskEndDate);
    }

    public void deleteTask(String id) {
        taskRepository.deleteTask(id);
    }

    public void deleteTasksByProjectId(String projectId) {
        taskRepository.deleteTasksByProjectId(projectId);
    }

    //TODO !null
}
