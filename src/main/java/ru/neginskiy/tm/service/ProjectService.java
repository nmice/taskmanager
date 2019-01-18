package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.repository.ProjectRepository;

import java.util.List;

public class ProjectService extends AbstractService<Project, ProjectRepository> {

    public ProjectService(ProjectRepository entityRepository) {
        this.entityRepository = entityRepository;
    }
}
