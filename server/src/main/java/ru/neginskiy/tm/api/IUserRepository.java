package ru.neginskiy.tm.api;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.neginskiy.tm.entity.User;

public interface IUserRepository {

    @Select("SELECT * FROM `user` WHERE login=#{login} AND passwordHash=#{passwordHash}")
    User findUser(String login, String passwordHash);

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
