package ru.neginskiy.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.neginskiy.tm.entity.User;

public interface IUserRepository {

    @Select("SELECT * FROM `user` WHERE login=#{login} AND passwordHash=#{passwordHash}")
    User findUser(@Param("login") String login, @Param("passwordHash")String passwordHash);

    @Select("SELECT * FROM `user` where id=#{id}")
    User getById(String id);

    @Insert("INSERT INTO `user` (id,login,passwordHash) VALUES (#{id}, #{login}, #{passwordHash}) " +
            "ON DUPLICATE KEY UPDATE login = #{login}, passwordHash = #{passwordHash}")
    void merge(User user);

    @Delete("DELETE FROM task where id=#{id}")
    int delete(String id);

    @Select("SELECT * FROM `user` where login=#{login}")
    User getByLogin(String login);
}
