package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.repository.ProjectRepository;

import java.util.List;

public class ProjectService extends AbstractService<Project> {

    private final ProjectRepository entityRepository;

    public ProjectService(ProjectRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public void merge(Project project) {
        if (project == null) {
            return;
        }
        entityRepository.merge(project);
    }

    public Project getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.getById(id);
    }

    public List<Project> getAll() {
        return entityRepository.getAll();
    }

    public Project delete(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.delete(id);
    }
}
