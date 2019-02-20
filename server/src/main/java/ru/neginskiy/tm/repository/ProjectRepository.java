package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProjectRepository implements IProjectRepository {

    private final EntityManager entityManager;

    public void close() {
        entityManager.close();
    }

    public EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }

    public ProjectRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public @NotNull List<Project> getAllByUserId(@NotNull String userId) {
        return entityManager
                .createQuery("from Project p where p.user.id=:paramUserId", Project.class)
                .setParameter("paramUserId", userId)
                .getResultList();
    }

    @Override
    public @Nullable Project getById(@NotNull String id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public void merge(@NotNull Project project) {
        entityManager.merge(project);
    }

    @Override
    public void delete(@NotNull Project project) {
        entityManager.remove(project);
    }
}