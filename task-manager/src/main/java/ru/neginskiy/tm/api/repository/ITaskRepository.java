
package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<Task, String> {

    @Query("select t FROM Task t where t.user.id = :userId")
    @NotNull List<Task> getAllByUserId(@NotNull @Param("userId") String userId);

    @Query("FROM Task t where t.project.id = ?1")
    @NotNull List<Task> getAllByProjectId(@NotNull String projectId);
}