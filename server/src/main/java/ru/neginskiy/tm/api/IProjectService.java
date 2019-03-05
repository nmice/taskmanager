package ru.neginskiy.tm.api;

import ru.neginskiy.tm.entity.Project;

import java.util.List;

public interface IProjectService {

    void merge(Project project);

    Project getById(String id);

    List<Project> getAll();

    Project delete(String id);
}
