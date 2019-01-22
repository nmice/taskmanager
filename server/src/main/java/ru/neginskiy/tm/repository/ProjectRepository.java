package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProjectRepository extends AbstractRepository<Project> {

    public List<Project> getAllByUserId(String userId) {
        Collection<Project> c = entityBase.values();
        List<Project> resultList = new ArrayList<>();
        for (Project project : c) {
            if (userId.equals(project.getUserId())) {
                resultList.add(project);
            }
        }
        return resultList;
    }
}
