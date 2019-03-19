package ru.neginskiy.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@ApplicationScoped
public class ProjectService{

    @Inject
    private IProjectRepository projectRepository;

    public @NotNull List<Project> getAll() {
        return projectRepository.findAll();
    }

    public @Nullable Project getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Project project = projectRepository.findBy(id);
        return project;
    }

    public void merge(@Nullable Project project) {
        if (project == null) {
            return;
        }
        projectRepository.merge(project);
    }

    public @Nullable Project deleteById(@Nullable String id) {
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