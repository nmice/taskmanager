package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;

import java.sql.Connection;
import java.util.List;

public class ProjectRepository extends AbstractRepository<Project>{

    public ProjectRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void merge(Project entity) {

    }

    @Override
    public Project getById(String id) {
        return null;
    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public Project delete(String id) {
        return null;
    }
}
