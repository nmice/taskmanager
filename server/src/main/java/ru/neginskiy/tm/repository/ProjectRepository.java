package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;

import javax.persistence.EntityManager;
import java.util.List;

public class ProjectRepository extends AbstractRepository<Project> implements IProjectRepository {

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
}