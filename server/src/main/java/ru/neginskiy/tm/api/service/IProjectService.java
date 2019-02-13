package ru.neginskiy.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Project;

import java.util.List;

public interface IProjectService {

    void merge(@Nullable Project project);

    @Nullable Project getById(@Nullable String id);

    @NotNull List<Project> getAllByUserId(@Nullable String userId);

    @Nullable Project delete(@Nullable String id);
}
