package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.neginskiy.tm.entity.Session;

import java.util.List;

@Repository
public interface ISessionRepository extends JpaRepository<Session, String> {

    @Query("select s FROM Session s where s.user.id = :userId")
    @NotNull List<Session> getAllByUserId(@NotNull @Param("userId") String userId);
}
