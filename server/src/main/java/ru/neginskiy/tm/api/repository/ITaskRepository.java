package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

//@Repository
public interface ITaskRepository extends IRepository<Task> {

    @NotNull List<Task> getAllByUserId(@NotNull String userId);

    void deleteByProjectId(@NotNull String projectId);
}
