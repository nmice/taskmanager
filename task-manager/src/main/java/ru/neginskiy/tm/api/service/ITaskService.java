package ru.neginskiy.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

public interface ITaskService {

    @NotNull List<Task> getAll();

    @Nullable Task getById(@Nullable String id);

    void merge(@Nullable Task task);

    @Nullable Task deleteById(@Nullable String id);

    @NotNull List<Task> getAllByProjectId(@NotNull String projectId);
}
