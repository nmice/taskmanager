package ru.neginskiy.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Project;

import java.util.List;

public interface IProjectService {

    @NotNull List<Project> getAll();

    @Nullable Project getById(@Nullable String id);

    void merge(@Nullable Project project);

    @Nullable Project deleteById(@Nullable String id);
}