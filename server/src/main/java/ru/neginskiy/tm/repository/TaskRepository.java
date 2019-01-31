package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Task;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TaskRepository extends AbstractRepository<Task> {

    public TaskRepository(Connection connection){
        this.connection = connection;
    }

    public List<Task> getAllByUserId(String userId) {
        Collection<Task> c = entityBase.values();
        List<Task> resultList = new ArrayList<>();
        for (Task project : c) {
            if (userId.equals(project.getUserId())) {
                resultList.add(project);
            }
        }
        return resultList;
    }

    public void deleteByProjectId(String projectId) {
        for (Task task : entityBase.values()) {
            if (projectId.equals(task.getProjectId())) {
                delete(task.getId());
            }
        }
    }

}
