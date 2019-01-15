package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.time.LocalDate;
import java.util.*;

public class TaskRepository {

    private Map<String, Task> taskBase = new HashMap<>();

    public void createTask(String taskName, String taskDescription, LocalDate taskDateBegin, LocalDate taskDateEnd, String projectId) {
        Task task = new Task();
        task.setName(taskName);
        task.setDescription(taskDescription);
        task.setDateBegin(taskDateBegin);
        task.setDateEnd(taskDateEnd);
        task.setProjectId(projectId);
        taskBase.put(task.getId(), task);
    }

    public Task getTaskById(String id) {
        return taskBase.get(id);
    }

    public List<Task> getAllTasks() {
        Collection<Task> c = taskBase.values();
        List<Task> allTasksList = new ArrayList<>();
        allTasksList.addAll(c);
        return allTasksList;
    }

    public void updateTaskName(String taskId, String taskName) {
        taskBase.get(taskId).setName(taskName);
    }

    public void updateTaskDescription(String taskId, String taskDescription) {
        taskBase.get(taskId).setName(taskDescription);
    }

    public void updateTaskEndDate(String taskId, LocalDate taskEndDate) {
        taskBase.get(taskId).setDateEnd(taskEndDate);
    }

/*    public void updateTask(Task task) {
        addTask(task);
    }*/

    public void deleteTask(String id) {
        taskBase.remove(id);
    }

    public void deleteTasksByProjectId(String projectId) {
        for (Task task : taskBase.values()) {
            if (projectId.equals(task.getProjectId())) {
                deleteTask(task.getId());
            }
        }
    }

    public int getTaskBaseSize() {
        return taskBase.size();
    }

}
