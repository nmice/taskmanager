package ru.neginskiy.tm.api;

import ru.neginskiy.tm.entity.User;

import java.util.List;

public interface IUserService {

    void merge(User user);

    User findUser(String login, String passwordHash);

    public boolean isRegistredLogin(String login);

}