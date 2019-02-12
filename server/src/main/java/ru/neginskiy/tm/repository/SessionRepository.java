package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Session;

import java.sql.Connection;
import java.util.List;

public class SessionRepository extends AbstractRepository<Session> {

    public SessionRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void merge(Session entity) {

    }

    @Override
    public Session getById(String id) {
        return null;
    }

    @Override
    public List<Session> getAll() {
        return null;
    }

    @Override
    public Session delete(String id) {
        return null;
    }
}
