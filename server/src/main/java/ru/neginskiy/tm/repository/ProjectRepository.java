package ru.neginskiy.tm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;

import java.util.List;

public class ProjectRepository implements IProjectRepository {

    private final SessionFactory sessionFactory;

    public ProjectRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public @NotNull List<Project> getAllByUserId(@NotNull String userId) {
        List<Project> projectList = (List<Project>) sessionFactory.openSession().createQuery("from task where userId=`userId").list();
        return projectList;
    }

    @Override
    public @Nullable Project getById(@NotNull String id) {
        return sessionFactory.openSession().get(Project.class, id);
    }

    @Override
    public void merge(@NotNull Project project) {
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        hibernateSession.saveOrUpdate(project);
        transaction.commit();
        hibernateSession.close();
    }

    @Override
    public void delete(@NotNull Project project) {
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        hibernateSession.delete(project);
        transaction.commit();
        hibernateSession.close();
    }
}
