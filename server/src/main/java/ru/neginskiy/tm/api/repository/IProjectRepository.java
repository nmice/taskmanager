package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.Project;

import java.util.List;

public interface IProjectRepository extends IRepository<Project>{

    @NotNull List<Project> getAllByUserId(@NotNull String userId);
}
