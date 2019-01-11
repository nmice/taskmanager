package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.time.LocalDate;
import java.util.*;

public class TaskRepository {

    public static Map<Integer, Task> taskBase = new HashMap<>();

    public static void createTask(String taskName, String taskDescription, LocalDate taskDateBegin, LocalDate taskDateEnd, int projectId) {
        Task task = new Task(taskName, taskDescription, taskDateBegin, taskDateEnd, projectId);
        taskBase.put(getNewId(), task);
        return;
    }

    public static void addTask(Task task) {
        taskBase.put(task.getTaskId(), task);
    }

    public static Task getTaskById(int id) {
        return taskBase.get(id);
    }

    public static List<Task> getAllTasks() {
        Collection<Task> c = taskBase.values();
        List<Task> allTasksList = new ArrayList<>();
        allTasksList.addAll(c);
        return allTasksList;
    }

    public static void updateTaskName(int taskId, String taskName) {
        taskBase.get(taskId).setTaskName(taskName);
    }

    public static void updateTaskDescription(int taskId, String taskDescription) {
        taskBase.get(taskId).setTaskName(taskDescription);
    }

    public static void updateTaskEndDate(int taskId, LocalDate taskEndDate) {
        taskBase.get(taskId).setTaskDateEnd(taskEndDate);
    }

    public static void updateTask(Task task) {
        addTask(task);
    }

    public static void deleteTask(int id) {
        taskBase.remove(id);
    }

    public static int getTaskBaseSize() {
        return taskBase.size();
    }

    public static int getNewId() {
        return getTaskBaseSize() + 1;
    }
}