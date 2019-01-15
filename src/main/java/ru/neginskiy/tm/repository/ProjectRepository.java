package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;

import java.time.LocalDate;
import java.util.*;

public class ProjectRepository {

    private Map<String, Project> projectBase = new HashMap<>();

    public void createProject(String projectName, String projectDescription, LocalDate projectDateBegin, LocalDate projectDateEnd) {
        Project project = new Project();
        project.setName(projectName);
        project.setDescription(projectDescription);
        project.setDateBegin(projectDateBegin);
        project.setDateEnd(projectDateEnd);
        projectBase.put(project.getId(), project);
    }

    public Project getProjectById(String id) {
        return projectBase.get(id);
    }

    public List<Project> getAllProjects() {
        Collection<Project> c = projectBase.values();
        List<Project> allProjectsList = new ArrayList<>();
        allProjectsList.addAll(c);
        return allProjectsList;
    }

    public void updateProjectName(String projectId, String projectName) {
        projectBase.get(projectId).setName(projectName);
    }

    public void updateProjectDescription(String projectId, String projectDescription) {
        projectBase.get(projectId).setName(projectDescription);
    }

    public void updateProjectEndDate(String projectId, LocalDate projectEndDate) {
        projectBase.get(projectId).setDateEnd(projectEndDate);
    }

    public void deleteProject(String id) {
        projectBase.remove(id);
    }

    public int getProjectBaseSize() {
        return projectBase.size();
    }
}
