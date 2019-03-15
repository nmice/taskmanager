package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Project;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProjectRepository extends AbstractRepository<Project> {

    @Override
    public @Nullable Project getById(@NotNull String id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public @NotNull List<Project> getAll() {
        return entityManager
                .createQuery("from Project p", Project.class)
                .getResultList();
    }
}
