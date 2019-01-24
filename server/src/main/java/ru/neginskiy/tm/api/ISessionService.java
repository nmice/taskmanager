package ru.neginskiy.tm.api;

import ru.neginskiy.tm.entity.Session;

public interface ISessionService {

    void merge(Session session);

    Session getById(String id);

    Session delete(String id);

    Session getNewSession(String userId);
}