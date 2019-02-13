package ru.neginskiy.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Project;

import java.util.List;

public interface IProjectRepository {

    @Select("SELECT * FROM project where userId=#{userId}")
    @NotNull List<Project> getAllByUserId(@NotNull String userId);

    @Select("SELECT * FROM project where id=#{id}")
    @Nullable Project getById(@NotNull String id);

    @Insert("INSERT INTO project (id,name,description,dateBegin,dateEnd,userId) VALUES (#{id}, #{name}, #{description}, " +
            "#{dateBegin}, #{dateEnd}, #{userId}) ON DUPLICATE KEY UPDATE name = #{name}, description = #{description}, " +
            "dateBegin = #{dateBegin}, dateEnd = #{dateEnd}, userId = #{userId}")
    void merge(@NotNull Project project);

    @Delete("DELETE FROM project where id=#{id}")
    int delete(@NotNull String id);
}
