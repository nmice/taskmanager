package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.time.LocalDate;
import java.util.*;

public class TaskRepository {

    public Map<Integer, Task> taskBase = new HashMap<>();

    public Task createTask(String taskName, String taskDescription, LocalDate taskDateBegin, LocalDate taskDateEnd, int projectId) {
        Task task = new Task(taskName, taskDescription, taskDateBegin, taskDateEnd, projectId);
        taskBase.put(task.getTaskId(), task);
        return task;
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

    public void updateTask(Task task) {
        addTask(task);
    }

    public void deleteTask(int id) {
        taskBase.remove(id);
    }

    public int getTaskBaseSize() {
        return taskBase.size();
    }

    public int getNewId() {
        return getTaskBaseSize() + 1;
    }
}