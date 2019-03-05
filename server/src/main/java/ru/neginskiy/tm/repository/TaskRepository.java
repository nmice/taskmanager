package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.util.Date;

public class TaskRepository extends AbstractRepository<Task> {

    private static TaskRepository instance;

    private TaskRepository(){}

    public static TaskRepository getInstance() {
        if (instance == null) {
            Task demoTask = new Task();
            demoTask.setId("TID");
            demoTask.setName("DEMO TASK");
            demoTask.setDescription("DESCRIPTION");
            demoTask.setDateBegin(new Date());
            demoTask.setDateEnd(new Date(System.currentTimeMillis() + 1_000_000_000));
            demoTask.setProjectId("PID");
            instance = new TaskRepository();
            instance.merge(demoTask);
            return instance;
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
