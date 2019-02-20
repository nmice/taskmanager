package ru.neginskiy.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.api.service.IProjectService;
import ru.neginskiy.tm.repository.ProjectRepository;

import java.util.ArrayList;
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
        if (userId == null || userId.isEmpty()) {
            return new ArrayList<>();
        }
        IProjectRepository projectRepository = getProjectRepository();
        List<Project> projectList = projectRepository.getAllByUserId(userId);
        projectRepository.close();
        return projectList;
    }

    @Override
    public @Nullable Project getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        IProjectRepository projectRepository = getProjectRepository();
        Project project = projectRepository.getById(id);
        projectRepository.close();
        return project;
    }

    @Override
    public void merge(@Nullable Project project) {
        if (project == null) {
            return;
        }
        IProjectRepository projectRepository = getProjectRepository();
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
        IProjectRepository projectRepository = getProjectRepository();

        Project project = getById(id);
        projectRepository.getTransaction().begin();
        projectRepository.delete(project);
        serviceLocator.getTaskService().deleteByProjectId(id);
        projectRepository.getTransaction().commit();
        projectRepository.close();
        return project;
    }
}
