package ru.neginskiy.tm.api;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.neginskiy.tm.entity.Project;

import java.util.List;

public interface IProjectRepository {

    @Select("SELECT * FROM project where userId=#{userId}")
    List<Project> getAllByUserId(String userId);

    @Select("SELECT * FROM project where id=#{id}")
    Project getById(String id);

    @Insert("INSERT INTO project (id,name,description,dateBegin,dateEnd,userId) VALUES (#{id}, #{name}, #{description}, " +
            "#{dateBegin}, #{dateEnd}, #{userId}) ON DUPLICATE KEY UPDATE name = #{name}, description = #{description}, " +
            "dateBegin = #{dateBegin}, dateEnd = #{dateEnd}, userId = #{userId}")
    void merge(Project project);

    @Delete("DELETE FROM project where id=#{id}")
    int delete(String id);
}
