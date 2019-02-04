package ru.neginskiy.tm.api;

import ru.neginskiy.tm.entity.Session;

public interface ISessionService {

    Session delete(String id);

    Session getNewSession(String userId);

    boolean isUncorrectSession(Session session);
}