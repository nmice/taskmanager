package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.util.*;

public class TaskRepository {

    private Map<String, Task> entityBase = new HashMap<>();

    public void merge(Task task) {
        entityBase.put(task.getId(), task);
    }

    public Task getById(String id) {
        return entityBase.get(id);
    }

    public List<Task> getAll() {
        Collection<Task> c = entityBase.values();
        List<Task> allTasksList = new ArrayList<>();
        allTasksList.addAll(c);
        return allTasksList;
    }

    public Task delete(String id) {
        Task task = entityBase.get(id);
        entityBase.remove(id);
        return task;
    }

    public void deleteByProjectId(String projectId) {
        for (Task task : entityBase.values()) {
            if (projectId.equals(task.getProjectId())) {
                delete(task.getId());
            }
        }
    }
}
