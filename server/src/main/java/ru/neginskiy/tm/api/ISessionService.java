package ru.neginskiy.tm.api;

import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.error.UncorrectSessionException;

public interface ISessionService {

    Session delete(String id);

    Session getNewSession(String userId);

    void validate(Session session) throws UncorrectSessionException;
}