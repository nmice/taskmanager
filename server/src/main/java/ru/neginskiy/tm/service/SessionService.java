package ru.neginskiy.tm.service;

import ru.neginskiy.tm.api.ISessionService;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.repository.SessionRepository;

import java.util.List;

public class SessionService implements ISessionService {

    private final SessionRepository entityRepository;

    public SessionService(SessionRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public void merge(Session session) {
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
