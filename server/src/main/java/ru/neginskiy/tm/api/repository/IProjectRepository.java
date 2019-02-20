package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Project;

import javax.persistence.EntityTransaction;
import java.util.List;

public interface IProjectRepository extends IRepository<Project>{

    @NotNull List<Project> getAllByUserId(@NotNull String userId);

    @Nullable Project getById(@NotNull String id);

    void merge(@NotNull Project project);

    void delete(@NotNull Project project);

    void close();

    EntityTransaction getTransaction();
}
