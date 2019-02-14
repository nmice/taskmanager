package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

public interface ITaskRepository {

    @NotNull List<Task> getAllByUserId(@NotNull String userId);

    @Nullable Task getById(@NotNull String id);

    void merge(@NotNull Task task);

    void delete(@NotNull Task task);

    void deleteByProjectId(@NotNull String projectId);
}
