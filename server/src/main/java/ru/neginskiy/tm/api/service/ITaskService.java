package ru.neginskiy.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

public interface ITaskService {

    void merge(@Nullable Task task);

    @Nullable Task getById(@Nullable String id);

    @NotNull List<Task> getAllByUserId(@Nullable String userId);

    @Nullable Task delete(@Nullable String id);

    void deleteByProjectId(@Nullable String projectId);
}