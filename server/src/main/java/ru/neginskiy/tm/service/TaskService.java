package ru.neginskiy.tm.service;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.api.service.ITaskService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Getter
@ApplicationScoped
public class TaskService implements ITaskService {

    @Inject
    private ITaskRepository taskRepository;

    @Override
    public @NotNull List<Task> getAllByUserId(@Nullable String userId) {
        if (userId == null || userId.isEmpty()) return Collections.emptyList();
        final ITaskRepository taskRepository = getTaskRepository();
        final List<Task> taskList = taskRepository.getAllByUserId(userId);
        taskRepository.close();
        return taskList;
    }

    @Override
    public @Nullable Task getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final ITaskRepository taskRepository = getTaskRepository();
        final Task task = taskRepository.getById(id);
        taskRepository.close();
        return task;
    }

    @Override
    public void merge(@Nullable Task task) {
        if (task == null) {
            return;
        }
        final ITaskRepository taskRepository = getTaskRepository();
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
        final ITaskRepository taskRepository = getTaskRepository();
        taskRepository.getTransaction().begin();
        final Task task = taskRepository.getById(id);
        if (task == null) {
            return null;
        }
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
        final ITaskRepository taskRepository = getTaskRepository();
        taskRepository.getTransaction().begin();
        taskRepository.deleteByProjectId(projectId);
        taskRepository.getTransaction().commit();
        taskRepository.close();
    }


}
