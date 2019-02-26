package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

public class TaskRepository extends AbstractRepository<Task> implements ITaskRepository {

    @Override
    public @NotNull List<Task> getAllByUserId(@NotNull String userId) {
        return entityManager
                .createQuery("from Task t where t.user.id=:paramUserId", Task.class)
                .setParameter("paramUserId", userId)
                .getResultList();
    }

    @Override
    public @Nullable Task getById(@NotNull String id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public void deleteByProjectId(@NotNull String projectId) {
        final List<Task> taskList = entityManager
                .createQuery("from Task t where t.project.id=:paramProjectId", Task.class)
                .setParameter("paramProjectId", projectId)
                .getResultList();
        for (Task task : taskList) {
            entityManager.remove(task);
        }
    }
}
