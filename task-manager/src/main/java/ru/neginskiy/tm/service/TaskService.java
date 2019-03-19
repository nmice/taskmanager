package ru.neginskiy.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Transactional
@ApplicationScoped
public class TaskService {

    @Inject
    private ITaskRepository taskRepository;

    public @NotNull List<Task> getAllByProjectId(@Nullable String projectId) {
        if (projectId == null || projectId.isEmpty()) return Collections.emptyList();
        final List<Task> taskList = taskRepository.getAllByProjectId(projectId);
        return taskList;
    }

    public @Nullable Task getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Task task = taskRepository.findBy(id);
        return task;
    }

    public void merge(@Nullable Task task) {
        if (task == null) {
            return;
        }
        taskRepository.merge(task);
    }

    public @Nullable Task deleteById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Task task = getById(id);
        if (task == null) {
            return null;
        }
        taskRepository.remove(task);
        return task;
    }
}
