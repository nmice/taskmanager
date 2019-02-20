package ru.neginskiy.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.api.service.ITaskService;
import ru.neginskiy.tm.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskService implements ITaskService {

    private final ServiceLocator serviceLocator;

    public TaskService(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    private ITaskRepository getTaskRepository() {
        return new TaskRepository(serviceLocator.getEntityManagerFactory().createEntityManager());
    }

    @Override
    public @NotNull List<Task> getAllByUserId(@Nullable String userId) {
        if (userId == null || userId.isEmpty()) {
            return new ArrayList<>();
        }
        ITaskRepository taskRepository = getTaskRepository();
        List<Task> taskList = taskRepository.getAllByUserId(userId);
        taskRepository.close();
        return taskList;
    }

    @Override
    public @Nullable Task getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        ITaskRepository taskRepository = getTaskRepository();
        Task task = taskRepository.getById(id);
        taskRepository.close();
        return task;
    }

    @Override
    public void merge(@Nullable Task task) {
        if (task == null) {
            return;
        }
        ITaskRepository taskRepository = getTaskRepository();
        taskRepository.getTransaction().begin();
        taskRepository.merge(task);
        taskRepository.getTransaction().commit();
        taskRepository.close();
    }

    @Override
    public @Nullable Task delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        ITaskRepository taskRepository = getTaskRepository();
        taskRepository.getTransaction().begin();
        Task task = taskRepository.getById(id);
        taskRepository.delete(task);
        taskRepository.getTransaction().commit();
        taskRepository.close();
        return task;
    }

    @Override
    public void deleteByProjectId(@Nullable String projectId) {
        if (projectId == null || projectId.isEmpty()) {
            return;
        }
        ITaskRepository taskRepository = getTaskRepository();
        taskRepository.getTransaction().begin();
        taskRepository.deleteByProjectId(projectId);
        taskRepository.getTransaction().commit();
        taskRepository.close();
    }


}
