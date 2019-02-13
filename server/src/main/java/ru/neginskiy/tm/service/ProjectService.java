package ru.neginskiy.tm.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.api.service.IProjectService;

import java.util.ArrayList;
import java.util.List;

public class ProjectService implements IProjectService {

    private final SqlSessionFactory sqlSessionFactory;

    public ProjectService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void merge(@Nullable Project project) {
        if (project == null) {
            return;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final IProjectRepository projectMapper = session.getMapper(IProjectRepository.class);
        projectMapper.merge(project);
        session.commit();
        session.close();
    }

    @Override
    public @Nullable Project getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final IProjectRepository projectMapper = session.getMapper(IProjectRepository.class);
        final Project project = projectMapper.getById(id);
        session.commit();
        session.close();
        return project;
    }

    @Override
    public @NotNull List<Project> getAllByUserId(@Nullable String userId) {
        if (userId == null || userId.isEmpty()) {
            return new ArrayList<>();
        }
        final SqlSession session = sqlSessionFactory.openSession();

        final IProjectRepository projectMapper = session.getMapper(IProjectRepository.class);

        final List<Project> projectList = projectMapper.getAllByUserId(userId);
        session.commit();
        session.close();
        return projectList;
    }

    @Override
    public @Nullable Project delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final IProjectRepository projectMapper = session.getMapper(IProjectRepository.class);
        final Project project = projectMapper.getById(id);
        if (project == null) {
            return null;
        }
        int counter = projectMapper.delete(id);
        if (counter == 0) {
            return null;
        }
        final ITaskRepository taskMapper = session.getMapper(ITaskRepository.class);
        taskMapper.deleteByProjectId(id);
        session.commit();
        session.close();
        return project;
    }
}
