package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TaskRepository extends AbstractRepository<Task> {

    public List<Task> getByProjectId(String projectId) {
        List<Task> allTaskList = getAll();
        List<Task> projectTaskList = new ArrayList<>();
        for (Task task : allTaskList) {
            if (task.getProjectId().equals(projectId)) {
                projectTaskList.add(task);
            }
        }
        return projectTaskList;
    }

    public void deleteByProjectId(String projectId) {
        for (Task task : getAll()) {
            if (projectId.equals(task.getProjectId())) {
                delete(task.getId());
            }
        }
    }
}
