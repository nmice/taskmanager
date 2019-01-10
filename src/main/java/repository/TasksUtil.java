package repository;

import entity.Task;

import java.time.LocalDate;
import java.util.*;

public class TasksUtil {

    public static final Map<Integer, Task> TASK_BASE = new HashMap<>();

    public static Task createTask(String taskName, String taskDescription, LocalDate taskDateBegin, LocalDate taskDateEnd, int projectId) {

        Task task = new Task(taskName, taskDescription, taskDateBegin, taskDateEnd, projectId);
        TASK_BASE.put(task.getTaskId(), task);
        return task;
    }

    public static void addTask(Task task) {
        TASK_BASE.put(task.getTaskId(), task);
    }

    public static Task getTaskById(int id) {
        return TASK_BASE.get(id);
    }

    public static List<Task> getAllTasks() {
        Collection<Task> c = TASK_BASE.values();
        List<Task> allTasksList = new ArrayList<>();
        allTasksList.addAll(c);
        return allTasksList;
    }

    public static void updateTask(Task task) {
        addTask(task);
    }

    public static void deleteTask(int id) {
        TASK_BASE.remove(id);
    }

    public static int getTaskBaseSize() {
        return TASK_BASE.size();
    }

    public static int getNewId() {
        return getTaskBaseSize() + 1;
    }
}