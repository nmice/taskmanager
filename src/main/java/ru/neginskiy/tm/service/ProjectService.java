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

    public void createProject(String name, String description, Date dateBegin, Date dateEnd) {
        projectRepository.createProject(name, description, dateBegin, dateEnd);
    }

    public Project getProjectById(String id) {
        return projectRepository.getProjectById(id);
    }

    public List<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    public void updateProjectName(String projectId, String projectName) {
        projectRepository.updateProjectName(projectId, projectName);
    }

    public void updateProjectDescription(String projectId, String projectDescription) {
        projectRepository.updateProjectDescription(projectId, projectDescription);
    }

    public void updateProjectEndDate(String projectId, Date dateEnd) {
        projectRepository.updateProjectEndDate(projectId, dateEnd);
    }

    public void deleteProject(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        if (projectRepository.getProjectById(id) == null) {
            return;
        }
        projectRepository.deleteProject(id);
    }//todo just business logic
}
