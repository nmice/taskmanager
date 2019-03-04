package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.Project;

import java.util.List;


@Repository(forEntity = Project.class)
public interface IProjectRepository extends FullEntityRepository<Project, String>{

    @Query("FROM Project p where p.user.id = ?1")
    @NotNull List<Project> getAllByUserId(@NotNull String userId);
}