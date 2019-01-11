package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;
import java.time.LocalDate;
import java.util.*;

public class ProjectRepository {

    public static Map<Integer, Project> projectBase = new HashMap<>();

    public static void createProject(String projectName, String projectDescription, LocalDate projectDateBegin, LocalDate projectDateEnd, int projectId) {
        Project project = new Project(projectId, projectName, projectDescription, projectDateBegin, projectDateEnd);
        projectBase.put(getNewId(), project);
        return;
    }

    public static void addProject(Project project) {
        projectBase.put(project.getProjectId(), project);
    }

    public static Project getProjectById(int id) {
        return projectBase.get(id);
    }

    public static List<Project> getAllProjects() {
        Collection<Project> c = projectBase.values();
        List<Project> allProjectsList = new ArrayList<>();
        allProjectsList.addAll(c);
        return allProjectsList;
    }

    public static void updateProjectName(int projectId, String projectName) {
        projectBase.get(projectId).setProjectName(projectName);
    }

    public static void updateProjectDescription(int projectId, String projectDescription) {
        projectBase.get(projectId).setProjectName(projectDescription);
    }

    public static void updateProjectEndDate(int projectId, LocalDate projectEndDate) {
        projectBase.get(projectId).setProjectDateEnd(projectEndDate);
    }

    public static void deleteProject(int id) {
        projectBase.remove(id);
    }

    public static int getProjectBaseSize() {
        return projectBase.size();
    }

    public static int getNewId() {
        return getProjectBaseSize() + 1;
    }
}
