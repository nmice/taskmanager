package ru.neginskiy.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.neginskiy.tm.entity.Session;

import java.util.List;

public interface ISessionRepository {

    @Select("SELECT * FROM session where userId=#{userId}")
    List<Session> getAllByUserId(String userId);

    @Select("SELECT * FROM session where id=#{id}")
    Session getById(String id);

    @Insert("INSERT INTO session (id,signature,timeStamp,userId) VALUES (#{id}, #{signature}, #{timeStamp}, #{userId}) " +
            "ON DUPLICATE KEY UPDATE signature = #{signature}, timeStamp = #{timeStamp}, userId = #{userId}")
    void merge(Session session);

    @Delete("DELETE FROM session where id=#{id}")
    int delete(String id);

    @Delete("DELETE FROM session where userId=#{userId}")
    int deleteByUserId(String userId);
}
