package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;

public class TaskService {
    TaskRepository taskRepository;

    public void createTask(String taskName, String taskDescription, LocalDate taskDateBegin, LocalDate taskDateEnd, String projectId) {
        taskRepository.createTask(taskName, taskDescription, taskDateBegin, taskDateEnd, projectId);
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public Task getTaskById(int id) {
        return taskRepository.getTaskById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public void updateTaskName(int taskId, String taskName) {
        taskRepository.updateTaskName(taskId, taskName);
    }

    public void updateTaskDescription(int taskId, String taskDescription) {
        taskRepository.updateTaskDescription(taskId, taskDescription);
    }

    public void updateTaskEndDate(int taskId, LocalDate taskEndDate) {
        taskRepository.updateTaskEndDate(taskId, taskEndDate);
    }

    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }

    public int getTaskBaseSize() {
        return taskRepository.getTaskBaseSize();
    }

    public TaskService(TaskRepository projectRepository) {
        this.taskRepository = projectRepository;
    }

    //TODO TRcode + TR obj + !null
}
