package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.time.LocalDate;
import java.util.*;

public class TaskRepository {

    public Map<String, Task> taskBase = new HashMap<>();

    public void createTask(String taskName, String taskDescription, LocalDate taskDateBegin, LocalDate taskDateEnd, String projectId) {
        Task task = new Task();
        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);
        task.setTaskDateBegin(taskDateBegin);
        task.setTaskDateEnd(taskDateEnd);
        task.setProjectId(projectId);
        taskBase.put(task.getTaskId(), task);
    }

    public void addTask(Task task) {
        taskBase.put(task.getTaskId(), task);
    }

    public Task getTaskById(int id) {
        return taskBase.get(id);
    }

    public List<Task> getAllTasks() {
        Collection<Task> c = taskBase.values();
        List<Task> allTasksList = new ArrayList<>();
        allTasksList.addAll(c);
        return allTasksList;
    }

    public void updateTaskName(int taskId, String taskName) {
        taskBase.get(taskId).setTaskName(taskName);
    }

    public void updateTaskDescription(int taskId, String taskDescription) {
        taskBase.get(taskId).setTaskName(taskDescription);
    }

    public void updateTaskEndDate(int taskId, LocalDate taskEndDate) {
        taskBase.get(taskId).setTaskDateEnd(taskEndDate);
    }

    public void updateTask(Task task) {
        addTask(task);
    }

    public void deleteTask(int id) {
        taskBase.remove(id);
    }

    public int getTaskBaseSize() {
        return taskBase.size();
    }
}