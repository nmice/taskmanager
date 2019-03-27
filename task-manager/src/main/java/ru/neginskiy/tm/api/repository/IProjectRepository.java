
package ru.neginskiy.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.neginskiy.tm.entity.Project;

import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<Project, String> {

    @Query("select p FROM Project p where p.user.id = :userId")
    @NotNull List<Project> getAll(@NotNull @Param("userId") String userId);
}