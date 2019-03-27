package ru.neginskiy.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.api.service.ITaskService;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public @NotNull List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public @Nullable Task getById(@Nullable String id) {
        if (id == null || id.isEmpty()) return null;
        final Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public void merge(@Nullable Task task) {
        if (task == null) {
            return;
        }
        taskRepository.save(task);
    }

    @Override
    public @Nullable Task deleteById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Optional<Task> optional = taskRepository.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        final Task task = optional.get();
        taskRepository.delete(task);
        return task;
    }
}