package ru.neginskiy.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.api.service.IProjectService;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProjectService implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public @NotNull List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public @Nullable Project getById(@Nullable String id) {
        if (id == null || id.isEmpty()) return null;
        final Optional<Project> project = projectRepository.findById(id);
        return project.orElse(null);
    }

    @Override
    public void merge(@Nullable Project project) {
        if (project == null) {
            return;
        }
        projectRepository.save(project);
    }

    @Override
    public @Nullable Project deleteById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final Optional<Project> optional = projectRepository.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        final Project project = optional.get();
        projectRepository.delete(project);
        return project;
    }
}