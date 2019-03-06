package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;

import java.util.Date;

public class ProjectRepository extends AbstractRepository<Project> {

    private static ProjectRepository instance;

    private ProjectRepository() {
    }

    public static ProjectRepository getInstance() {
        if (instance == null) {
            Project demoProject = new Project();
            demoProject.setId("PID");
            demoProject.setName("DEMO PROJECT");
            demoProject.setDescription("DESCRIPTION");
            demoProject.setDateBegin(new Date());
            demoProject.setDateEnd(new Date(System.currentTimeMillis() + 1_000_000_000));
            instance = new ProjectRepository();
            instance.merge(demoProject);
            return instance;
        }
        return instance;
    }
}
