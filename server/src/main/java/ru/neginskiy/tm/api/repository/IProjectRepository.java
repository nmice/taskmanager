package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.Project;

import java.util.List;


@Repository(forEntity = Project.class)
public interface IProjectRepository extends FullEntityRepository<Project, String>{

    @NotNull List<Project> getAllByUserId(@NotNull String userId);
}