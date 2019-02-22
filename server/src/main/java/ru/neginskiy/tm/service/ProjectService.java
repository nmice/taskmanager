package ru.neginskiy.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.api.service.IProjectService;
import ru.neginskiy.tm.repository.ProjectRepository;

import java.util.Collections;
import java.util.List;

public class ProjectService implements IProjectService {

    private final ServiceLocator serviceLocator;

    public ProjectService(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    private IProjectRepository getProjectRepository() {
        return new ProjectRepository(serviceLocator.getEntityManagerFactory().createEntityManager());
    }

    @Override
    public @NotNull List<Project> getAllByUserId(@Nullable String userId) {
        if (userId == null || userId.isEmpty()) return Collections.emptyList();
        final IProjectRepository projectRepository = getProjectRepository();
        final List<Project> projectList = projectRepository.getAllByUserId(userId);
        projectRepository.close();
        return projectList;
    }

    @Override
    public @Nullable Project getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final IProjectRepository projectRepository = getProjectRepository();
        final Project project = projectRepository.getById(id);
        projectRepository.close();
        return project;
    }

    @Override
    public void merge(@Nullable Project project) {
        if (project == null) {
            return;
        }
        final IProjectRepository projectRepository = getProjectRepository();
        projectRepository.getTransaction().begin();
        projectRepository.merge(project);
        projectRepository.getTransaction().commit();
        projectRepository.close();
    }

    @Override
    public @Nullable Project delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final IProjectRepository projectRepository = getProjectRepository();
        final Project project = getById(id);
        if (project == null) {
            return null;
        }
        projectRepository.getTransaction().begin();
        serviceLocator.getTaskService().deleteByProjectId(id);
        projectRepository.delete(project);
        projectRepository.getTransaction().commit();
        projectRepository.close();
        return project;
    }
}