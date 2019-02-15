package ru.neginskiy.tm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

public class TaskRepository implements ITaskRepository {

    private final SessionFactory sessionFactory;

    public TaskRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public @NotNull List<Task> getAllByUserId(@NotNull String userId) {
        Query query = sessionFactory.openSession().createQuery("from Task where userId=:paramUserId");
        query.setParameter("paramUserId",userId);
        List<Task> taskList = (List<Task>) query.list();
        return taskList;
    }

    @Override
    public @Nullable Task getById(@NotNull String id) {
        return sessionFactory.openSession().get(Task.class, id);
    }

    @Override
    public void merge(@NotNull Task task) {
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        hibernateSession.saveOrUpdate(task);
        transaction.commit();
        hibernateSession.close();
    }

    @Override
    public void delete(@NotNull Task task) {
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        hibernateSession.delete(task);
        transaction.commit();
        hibernateSession.close();
    }

    @Override
    public void deleteByProjectId(@NotNull String projectId) {
        Query query = sessionFactory.openSession().createQuery("from Task where projectId=:paramProjectId");
        query.setParameter("paramProjectId",projectId);
        List<Task> taskList = (List<Task>) query.list();
        for (Task task: taskList){
            delete(task);
        }
    }
}
