package ru.neginskiy.tm.api;

import org.apache.ibatis.annotations.*;
import ru.neginskiy.tm.entity.Project;

import java.util.List;

public interface IProjectRepository {

    @Select("SELECT * FROM project")
    List<Project> getAll();

    @Select("SELECT * FROM project where userId=#{userId}")
/*    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "dateBegin", column = "dateBegin"),
            @Result(property = "dateEnd", column = "dateEnd"),
            @Result(property = "userId", column = "userId")
    })*/
    List<Project> getAllByUserId(String userId);

    @Select("SELECT * FROM project where id=#{id}")
    Project getById(String id);

/*    @Insert("INSERT INTO project (id,name,description,dateBegin,dateEnd,userId) VALUES (#{id}, #{name}, #{description}, " +
            "#{dateBegin}, #{dateEnd}, #{userId} ON DUPLICATE KEY UPDATE id = VALUES(id), name = VALUES(name), description = VALUES(description), " +
            "dateBegin = VALUES(dateBegin), dateEnd = VALUES(dateEnd), userId = VALUES(userId)")*/

    @Update("UPDATE project set name = #{name}, description = #{description}, dateBegin = #{dateBegin}, " +
            "dateEnd = #{dateEnd}, userId = #{userId}")
    void merge(Project project);

    @Delete("DELETE FROM project where id=#{id}")
    int delete(String id);
}
