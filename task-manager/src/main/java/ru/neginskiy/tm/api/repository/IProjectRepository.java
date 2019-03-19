package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import ru.neginskiy.tm.entity.Project;

@Repository(forEntity = Project.class)
public interface IProjectRepository extends FullEntityRepository<Project, String> {
}