package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

@Repository
public interface ITaskRepository extends FullEntityRepository<Task, String> {

    @Query("FROM Task t where t.project.id = ?1")
    @NotNull List<Task> getAllByProjectId(@NotNull String projectId);
}
