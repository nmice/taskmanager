package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.repository.ProjectRepository;

import java.util.Date;
import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void merge(Project project) {
        projectRepository.merge(project);
    }

    public Project getById(String id) {
        if (projectRepository.getById(id) == null) {
            return null;
        }
        return projectRepository.getById(id);
    }

    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    public void updateName(String id, String name) {
        projectRepository.updateName(id, name);
    }

    public void updateDescription(String id, String description) {
        projectRepository.updateDescription(id, description);
    }

    public void updateEndDate(String id, Date endDate) {
        projectRepository.updateEndDate(id, endDate);
    }

    public Project delete(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        if (projectRepository.getById(id) == null) {
            return null;
        }
        return projectRepository.delete(id);
    }

     //todo just business logic
}
