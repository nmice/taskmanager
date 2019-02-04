package ru.neginskiy.tm.service;

import org.apache.commons.codec.digest.DigestUtils;
import ru.neginskiy.tm.api.ISessionService;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.repository.SessionRepository;
import ru.neginskiy.tm.util.AppConfig;

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
        final Session session = new Session();
        session.setUserId(userId);

        final String secretKey = AppConfig.secretKey;
        final int saltCounter = AppConfig.saltCounter;

        String signature = DigestUtils.md5Hex(session.getId());
        for (int i = 0; i < saltCounter; i++) {
            signature = DigestUtils.md5Hex(signature + secretKey);
        }
        session.setSignature(signature);
        entityRepository.merge(session);//Add to Session repository
        return session;
    }

    @Override
    public boolean isUncorrectSession(Session session) {
        if (session == null) {
            return true;
        }
        return entityRepository.isUncorrectSession(session);
    }

}
