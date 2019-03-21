package ru.neginskiy.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.api.service.ITaskService;

import javax.persistence.EntityManagerFactory;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
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
        final Task task = taskRepository.getOne(id);
        return task;
    }

    @Override
    public void merge(@Nullable Task task) {
        if (task == null) {
            return;
        }
        taskRepository.save(task);
    }

    @Override
    public @Nullable Task delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Task task = getById(id);
        if (task == null) {
            return null;
        }
        taskRepository.delete(task);
        return task;
    }
}
