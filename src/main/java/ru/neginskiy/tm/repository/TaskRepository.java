package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.util.*;

public class TaskRepository {

    private Map<String, Task> taskBase = new HashMap<>();

    public void merge(Task task) {
        taskBase.put(task.getId(), task);
    }//TODO for create and update

    public Task getTaskById(String id) {
        return taskBase.get(id);
    }

    public List<Task> getAllTasks() {
        Collection<Task> c = taskBase.values();
        List<Task> allTasksList = new ArrayList<>();
        allTasksList.addAll(c);
        return allTasksList;
    }

    public void updateTaskName(String id, String name) {
        taskBase.get(id).setName(name);
    }

    public void updateTaskDescription(String id, String description) {
        taskBase.get(id).setDescription(description);
    }

    public void updateTaskEndDate(String id, Date dateEnd) {
        taskBase.get(id).setDateEnd(dateEnd);
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
}
