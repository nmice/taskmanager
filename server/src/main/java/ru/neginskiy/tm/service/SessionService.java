package ru.neginskiy.tm.service;

import ru.neginskiy.tm.api.ISessionService;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.repository.SessionRepository;

public class SessionService implements ISessionService {

    private final SessionRepository entityRepository;

    public SessionService(SessionRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public void merge(Session session) {
        if (session == null) {
            return;
        }
        entityRepository.merge(session);
    }

    @Override
    public Session getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.getById(id);
    }

    @Override
    public Session delete(String id) {
        if (id == null) {
            return null;
        }
        return entityRepository.delete(id);
    }

    @Override
    public Session getNewSession(String userId) {
        if (userId == null) {
            return null;
        }
        return entityRepository.getNewSession(userId);
    }

    @Override
    public boolean isUncorrectSession(Session session) {
        if (session == null) {
            return true;
        }
        return entityRepository.isUncorrectSession(session);
    }

}
