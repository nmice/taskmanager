package ru.neginskiy.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.User;

public interface IUserRepository {

    @Select("SELECT * FROM `user` WHERE login=#{login} AND passwordHash=#{passwordHash}")
    @Nullable User findUser(@Param("login") @NotNull String login, @Param("passwordHash")@NotNull String passwordHash);

    @Select("SELECT * FROM `user` where id=#{id}")
    @Nullable User getById(@NotNull String id);

    @Insert("INSERT INTO `user` (id,login,passwordHash) VALUES (#{id}, #{login}, #{passwordHash}) " +
            "ON DUPLICATE KEY UPDATE login = #{login}, passwordHash = #{passwordHash}")
    void merge(@NotNull User user);

    @Delete("DELETE FROM task where id=#{id}")
    int delete(@NotNull String id);

    @Select("SELECT * FROM `user` where login=#{login}")
    @Nullable User getByLogin(@NotNull String login);
}
