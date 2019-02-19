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

    public IProjectRepository getProjectRepository() {
        return new ProjectRepository(serviceLocator.getEntityManagerFactory().createEntityManager());
    }

    @Override
    public void merge(@Nullable Project project) {
        if (project == null) {
            return;
        }

        getProjectRepository().merge(project);

    }

    @Override
    public @Nullable Project getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return projectRepository.getById(id);
    }

    @Override
    public @NotNull List<Project> getAllByUserId(@Nullable String userId) {
        if (userId == null || userId.isEmpty()) {
            return new ArrayList<>();
        }
        return projectRepository.getAllByUserId(userId);
}

    @Override
    public @Nullable Project delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        Project project = getById(id);
        projectRepository.delete(project);
        taskRepository.deleteByProjectId(id);
        return project;
    }
}
