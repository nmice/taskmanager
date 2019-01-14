package ru.neginskiy.tm.service;

import ru.neginskiy.tm.repository.ProjectRepository;

public class ProjectService {

    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }
}
