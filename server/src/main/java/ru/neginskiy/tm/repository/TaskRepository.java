package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

public class TaskRepository extends AbstractRepository<Task> {

    private static TaskRepository instance;

    private TaskRepository(){}

    public static TaskRepository getInstance() {
        if (instance == null) {
            return new TaskRepository();
        }
        return instance;
    }

    public void deleteByProjectId(String projectId) {
        for (Task task : getAll()) {
            if (projectId.equals(task.getProjectId())) {
                delete(task.getId());
            }
        }
    }
}
