package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.repository.ProjectRepository;

import java.time.LocalDate;
import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public void createProject(String projectName, String projectDescription, LocalDate projectDateBegin, LocalDate projectDateEnd) {
        projectRepository.createProject(projectName, projectDescription, projectDateBegin, projectDateEnd);
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

    public void updateProjectEndDate(String projectId, LocalDate projectEndDate) {
        projectRepository.updateProjectEndDate(projectId, projectEndDate);
    }

    public void deleteProject(String id) {
        projectRepository.deleteProject(id);
    }

}
