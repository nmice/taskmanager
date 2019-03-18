package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@ApplicationScoped
public class TaskRepository extends AbstractRepository<Task> {

    @Override
    public @Nullable Task getById(@NotNull String id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public @NotNull List<Task> getAll() {
        return entityManager
                .createQuery("from Task t", Task.class)
                .getResultList();
    }

    public @NotNull List<Task> getByProjectId(@NotNull String projectId) {
        return entityManager
                .createQuery("from Task t where t.project.id=:paramProjectId", Task.class)
                .setParameter("paramProjectId", projectId)
                .getResultList();
    }
}
