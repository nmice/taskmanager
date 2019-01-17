package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;

import java.util.*;

public class ProjectRepository {

    private Map<String, Project> projectBase = new HashMap<>();

    public void merge(Project project){
        projectBase.put(project.getId(), project);
    }//TODO for create and update

    public void createProject(String name, String description, Date dateBegin, Date dateEnd) {
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        project.setDateBegin(dateBegin);
        project.setDateEnd(dateEnd);
        projectBase.put(project.getId(), project);
    }

    public Project getById(String id) {
        return projectBase.get(id);
    }

    public List<Project> getAll() {
        Collection<Project> c = projectBase.values();
        List<Project> allProjectsList = new ArrayList<>();
        allProjectsList.addAll(c);
        return allProjectsList;
    }

    public void updateName(String projectId, String projectName) {
        projectBase.get(projectId).setName(projectName);
    }

    public void updateDescription(String projectId, String projectDescription) {
        projectBase.get(projectId).setName(projectDescription);
    }

    public void updateEndDate(String projectId, Date projectEndDate) {
        projectBase.get(projectId).setDateEnd(projectEndDate);
    }

    public Project delete(String id) {
        Project project = projectBase.get(id);
        projectBase.remove(id);
        return project;
    }//todo read wright
}
