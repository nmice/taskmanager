package ru.neginskiy.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.api.service.ITaskService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import java.util.Collections;
import java.util.List;

@Transactional
@ApplicationScoped
public class TaskService implements ITaskService {

    @Inject
    private ITaskRepository taskRepository;

    @Inject
    EntityManagerFactory entityManagerFactory;

    @Override
    public @NotNull List<Task> getAllByUserId(@Nullable String userId) {
        if (userId == null || userId.isEmpty()) return Collections.emptyList();
        final List<Task> taskList = taskRepository.getAllByUserId(userId);
        return taskList;
    }

    @Override
    public @Nullable Task getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Task task = taskRepository.getById(id);
        return task;
    }

    @Override
    public void merge(@Nullable Task task) {
        if (task == null) {
            return;
        }
        taskRepository.merge(task);
    }

    @Override
    public @Nullable Task delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Task task = taskRepository.getById(id);
        if (task == null) {
            return null;
        }
        taskRepository.delete(task);
        return task;
    }

    @Override
    public void deleteByProjectId(@Nullable String projectId) {
        if (projectId == null || projectId.isEmpty()) {
            return;
        }
        taskRepository.deleteByProjectId(projectId);
    }
}
