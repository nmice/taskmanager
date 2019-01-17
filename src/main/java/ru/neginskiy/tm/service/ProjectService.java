package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.repository.ProjectRepository;

import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void merge(Project project) {
        if (project == null) {
            return;
        }
        projectRepository.merge(project);
    }

    public Project getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return projectRepository.getById(id);
    }

    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    public Project delete(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return projectRepository.delete(id);
    }
}
