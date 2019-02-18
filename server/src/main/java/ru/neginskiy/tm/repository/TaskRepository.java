package ru.neginskiy.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TaskRepository implements ITaskRepository {

    private final EntityManagerFactory entityManagerFactory;

    public TaskRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public @NotNull List<Task> getAllByUserId(@NotNull String userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Task> taskList = entityManager
                .createQuery("from Task t where t.userId=:paramUserId", Task.class)
                .setParameter("paramUserId", userId)
                .getResultList();
        entityManager.close();
        return taskList;
    }

    @Override
    public @Nullable Task getById(@NotNull String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Task task = entityManager.find(Task.class, id);
        entityManager.close();
        return task;
    }

    @Override
    public void merge(@NotNull Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(@NotNull Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteByProjectId(@NotNull String projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Task> taskList = entityManager
                .createQuery("from Task t where t.projectId=:paramProjectId", Task.class)
                .setParameter("paramProjectId", projectId)
                .getResultList();
        for (Task task : taskList) {
            entityManager.remove(task);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
