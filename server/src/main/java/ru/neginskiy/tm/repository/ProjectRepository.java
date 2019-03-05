package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;

public class ProjectRepository extends AbstractRepository<Project> {

    private static ProjectRepository instance;

    private ProjectRepository(){}

    public static ProjectRepository getInstance() {
        if (instance == null) {
           return new ProjectRepository();
        }
        return instance;
    }

}
