package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

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

    public void deleteByProjectId(@NotNull String projectId) {
        final List<Task> taskList = entityManager
                .createQuery("from Task t where t.project.id=:paramProjectId", Task.class)
                .setParameter("paramProjectId", projectId)
                .getResultList();
        for (Task task : taskList) {
            entityManager.remove(task);
        }
    }

    public List<Task> getByProjectId(@NotNull String projectId) {
        return entityManager
                .createQuery("from Task t where t.project.id=:paramProjectId", Task.class)
                .setParameter("paramProjectId", projectId)
                .getResultList();
    }
}
