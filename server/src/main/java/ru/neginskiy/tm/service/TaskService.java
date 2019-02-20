package ru.neginskiy.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.api.service.ITaskService;
import ru.neginskiy.tm.repository.TaskRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TaskService implements ITaskService {

    private final ServiceLocator serviceLocator;

    public TaskService(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void merge(@Nullable Task task) {
        if (task == null) {
            return;
        }
        taskRepository.merge(task);
    }

    @Override
    public @Nullable Task getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return taskRepository.getById(id);
    }

    @Override
    public @NotNull List<Task> getAllByUserId(@Nullable String userId) {
        if (userId == null || userId.isEmpty()) {
            return new ArrayList<>();
        }
        return taskRepository.getAllByUserId(userId);
    }

    @Override
    public @Nullable Task delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        Task task = getById(id);
        taskRepository.delete(task);
        return task;
    }

    @Override
    public void deleteByProjectId(@NotNull String projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Task> taskList = entityManager
                .createQuery("from Task t where t.project.id=:paramProjectId", Task.class)
                .setParameter("paramProjectId", projectId)
                .getResultList();
        for (Task task : taskList) {
            entityManager.remove(task);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
