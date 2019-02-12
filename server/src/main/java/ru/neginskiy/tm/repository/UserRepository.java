package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.User;

import java.sql.Connection;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void merge(User entity) {

    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User delete(String id) {
        return null;
    }
}
