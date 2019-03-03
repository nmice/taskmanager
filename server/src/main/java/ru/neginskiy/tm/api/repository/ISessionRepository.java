package ru.neginskiy.tm.api.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.Session;

import java.util.List;

@Repository
public interface ISessionRepository extends FullEntityRepository<Session, String> {

    @Query("FROM Session s where s.user.id = ?1")
    @NotNull List<Session> getAllByUserId(@NotNull String userId);
}
