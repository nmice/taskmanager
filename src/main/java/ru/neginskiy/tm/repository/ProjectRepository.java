package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.time.LocalDate;
import java.util.*;

public class ProjectRepository {

    public Map<String, Project> projectBase = new HashMap<>();

    public void createProject(String projectName, String projectDescription, LocalDate projectDateBegin, LocalDate projectDateEnd, String projectId) {
        Project project = new Project();
        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);
        project.setProjectDateBegin(projectDateBegin);
        project.setProjectDateEnd(projectDateEnd);
        project.setProjectId(projectId);
        projectBase.put(project.getProjectId(), project);
    }

    public void addProject(Project project) {
        projectBase.put(project.getProjectId(), project);
    }

    public Project getProjectById(int id) {
        return projectBase.get(id);
    }

    public List<Project> getAllProjects() {
        Collection<Project> c = projectBase.values();
        List<Project> allProjectsList = new ArrayList<>();
        allProjectsList.addAll(c);
        return allProjectsList;
    }

    public void updateProjectName(int projectId, String projectName) {
        projectBase.get(projectId).setProjectName(projectName);
    }

    public void updateProjectDescription(int projectId, String projectDescription) {
        projectBase.get(projectId).setProjectName(projectDescription);
    }

    public void updateProjectEndDate(int projectId, LocalDate projectEndDate) {
        projectBase.get(projectId).setProjectDateEnd(projectEndDate);
    }

    public void deleteProject(int id) {
        projectBase.remove(id);
    }

    public int getProjectBaseSize() {
        return projectBase.size();
    }
}
