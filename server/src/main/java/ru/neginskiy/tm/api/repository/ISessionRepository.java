package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.Session;

import java.util.List;

@Repository
public interface ISessionRepository extends IRepository<Session> {

    @NotNull List<Session> getAllByUserId(@NotNull String userId);
}
