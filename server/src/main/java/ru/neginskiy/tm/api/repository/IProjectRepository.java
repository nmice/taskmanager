package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.Project;

import java.util.List;


//@Repository
public interface IProjectRepository extends IRepository<Project>{

    @NotNull List<Project> getAllByUserId(@NotNull String userId);
}