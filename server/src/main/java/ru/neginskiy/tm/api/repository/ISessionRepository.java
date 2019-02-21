package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.Session;

import java.util.List;

public interface ISessionRepository extends IRepository<Session> {

    @NotNull List<Session> getAllByUserId(@NotNull String userId);
}
