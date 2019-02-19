package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProjectRepository implements IProjectRepository {

    private final EntityManagerFactory entityManagerFactory;

    public ProjectRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public @NotNull List<Project> getAllByUserId(@NotNull String userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Project> projectList = entityManager
                .createQuery("from Project p where p.user.id=:paramUserId", Project.class)
                .setParameter("paramUserId", userId)
                .getResultList();
        entityManager.close();
        return projectList;
    }

    @Override
    public @Nullable Project getById(@NotNull String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Project project = entityManager.find(Project.class, id);
        entityManager.close();
        return project;
    }

    @Override
    public void merge(@NotNull Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(@NotNull Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}