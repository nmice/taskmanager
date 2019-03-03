package ru.neginskiy.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.api.service.IProjectService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Transactional
@ApplicationScoped
public class ProjectService implements IProjectService {

    @Inject
    private IProjectRepository projectRepository;

    @Override
    public @NotNull List<Project> getAllByUserId(@Nullable String userId) {
        if (userId == null || userId.isEmpty()) return Collections.emptyList();
        return projectRepository.getAllByUserId(userId);
    }

    @Override
    public @Nullable Project getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Project project = projectRepository.findBy(id);
        return project;
    }

    @Override
    public void merge(@Nullable Project project) {
        if (project == null) {
            return;
        }
        projectRepository.merge(project);
    }

    @Override
    public @Nullable Project delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Project project = getById(id);
        if (project == null) {
            return null;
        }
        projectRepository.remove(project);
        return project;
    }
}