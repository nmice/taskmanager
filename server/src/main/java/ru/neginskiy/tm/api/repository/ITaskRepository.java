package ru.neginskiy.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

public interface ITaskRepository {

    @Select("SELECT * FROM task where userId=#{userId}")
    @NotNull List<Task> getAllByUserId(@NotNull String userId);

    @Select("SELECT * FROM task where id=#{id}")
    @Nullable Task getById(@NotNull String id);

    @Insert("INSERT INTO task (id,name,description,dateBegin,dateEnd,projectId,userId) VALUES (#{id}, #{name}, #{description}, " +
            "#{dateBegin}, #{dateEnd}, #{projectId}, #{userId}) ON DUPLICATE KEY UPDATE name = #{name}, description = #{description}, " +
            "dateBegin = #{dateBegin}, dateEnd = #{dateEnd}, projectId = #{projectId}, userId = #{userId}")
    void merge(@NotNull Task task);

    @Delete("DELETE FROM task where id=#{id}")
    int delete(@NotNull String id);

    @Delete("DELETE FROM task where projectId=#{projectId}")
    void deleteByProjectId(@NotNull String projectId);
}
