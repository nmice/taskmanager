package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.util.*;

public class TaskRepository {

    private Map<String, Task> entityBase = new HashMap<>();

    public void merge(Task task) {
        entityBase.put(task.getId(), task);
    }//TODO for create and update

    public Task getById(String id) {
        return entityBase.get(id);
    }

    public List<Task> getAll() {
        Collection<Task> c = entityBase.values();
        List<Task> allTasksList = new ArrayList<>();
        allTasksList.addAll(c);
        return allTasksList;
    }

    public void updateName(String id, String name) {
        entityBase.get(id).setName(name);
    }

    public void updateDescription(String id, String description) {
        entityBase.get(id).setDescription(description);
    }

    public void updateEndDate(String id, Date dateEnd) {
        entityBase.get(id).setDateEnd(dateEnd);
    }

    public void delete(String id) {
        entityBase.remove(id);
    }

    public void deleteByProjectId(String projectId) {
        for (Task task : entityBase.values()) {
            if (projectId.equals(task.getProjectId())) {
                delete(task.getId());
            }
        }
    }
}
