package ru.neginskiy.tm.api;

import ru.neginskiy.tm.entity.User;

import java.util.List;

public interface IUserService {

    void merge(User user);

    User getById(String id);

    List<User> getAll();

    User delete(String id);

}