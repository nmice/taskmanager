package ru.neginskiy.tm.api;

import ru.neginskiy.tm.entity.Session;

import java.util.List;

public interface ISessionService {

    void merge(Session session);

    Session getById(String id);

    List<Session> getAll();

    Session delete(String id);

}