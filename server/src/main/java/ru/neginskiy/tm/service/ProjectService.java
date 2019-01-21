package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.api.IProjectService;
import ru.neginskiy.tm.repository.ProjectRepository;

import java.util.List;

public class ProjectService implements IProjectService {

    private final ProjectRepository entityRepository;

    public ProjectService(ProjectRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public void merge(Project project) {
        if (project == null) {
            return;
        }
        entityRepository.merge(project);
    }

    @Override
    public Project getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.getById(id);
    }

    @Override
    public List<Project> getAll() {
        return entityRepository.getAll();
    }

    @Override
    public Project delete(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.delete(id);
    }
}
