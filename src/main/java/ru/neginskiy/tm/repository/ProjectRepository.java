package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;

import java.util.*;

public class ProjectRepository {

    private Map<String, Project> entityBase = new HashMap<>();

    public void merge(Project project){
        entityBase.put(project.getId(), project);
    }

    public Project getById(String id) {
        return entityBase.get(id);
    }

    public List<Project> getAll() {
        Collection<Project> c = entityBase.values();
        List<Project> allProjectsList = new ArrayList<>();
        allProjectsList.addAll(c);
        return allProjectsList;
    }

    public Project delete(String id) {
        Project project = entityBase.get(id);
        entityBase.remove(id);
        return project;
    }
}
