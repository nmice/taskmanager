package ru.neginskiy.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

public interface ITaskRepository {

    @Select("SELECT * FROM task where userId=#{userId}")
    List<Task> getAllByUserId(String userId);

    @Select("SELECT * FROM task where id=#{id}")
    Task getById(String id);

    @Insert("INSERT INTO task (id,name,description,dateBegin,dateEnd,projectId,userId) VALUES (#{id}, #{name}, #{description}, " +
            "#{dateBegin}, #{dateEnd}, #{projectId}, #{userId}) ON DUPLICATE KEY UPDATE name = #{name}, description = #{description}, " +
            "dateBegin = #{dateBegin}, dateEnd = #{dateEnd}, projectId = #{projectId}, userId = #{userId}")
    void merge(Task task);

    @Delete("DELETE FROM task where id=#{id}")
    int delete(String id);

    @Delete("DELETE FROM task where projectId=#{projectId}")
    int deleteByProjectId(String projectId);
}
