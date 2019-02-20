package ru.neginskiy.tm.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.api.repository.ISessionRepository;
import ru.neginskiy.tm.api.service.ISessionService;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.error.UncorrectSessionException;
import ru.neginskiy.tm.repository.SessionRepository;
import ru.neginskiy.tm.util.AppConfig;

import java.util.List;

public class SessionService implements ISessionService {

    private static final int SESSION_LIFETIME = AppConfig.sessionLifetime;
    private static final String SECRET_KEY = AppConfig.secretKey;
    private static final int SALT_COUNTER = AppConfig.saltCounter;

    private final ServiceLocator serviceLocator;

    public SessionService(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    private ISessionRepository getSessionRepository() {
        return new SessionRepository(serviceLocator.getEntityManagerFactory().createEntityManager());
    }

    @Override
    public @Nullable Session getNewSession(@Nullable User user) {
        if (user == null) {
            return null;
        }
        final ISessionRepository sessionRepository = getSessionRepository();
        sessionRepository.getTransaction().begin();
        //Delete old session by User
        final List<Session> sessionList = sessionRepository.getAllByUserId(user.getId());
        for (Session session : sessionList) {
            if (System.currentTimeMillis() - session.getTimeStamp().getTime() > SESSION_LIFETIME) {
                sessionRepository.delete(session);
            }
        }
        //Create new Session:
        final Session session = new Session();
        session.setUser(user);
        session.setSignature(createSaltHashSignature(session.getId()));
        sessionRepository.merge(session);
        sessionRepository.getTransaction().commit();
        sessionRepository.close();
        return session;
    }

    @Override
    public @Nullable Session delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final ISessionRepository sessionRepository = getSessionRepository();
        sessionRepository.getTransaction().begin();
        final Session session = sessionRepository.getById(id);
        sessionRepository.delete(session);
        sessionRepository.getTransaction().commit();
        sessionRepository.close();
        return session;
    }

    @Override
    public void validate(@Nullable Session session) throws UncorrectSessionException {
        if (session == null) {
            throw new UncorrectSessionException();
        }
        final ISessionRepository sessionRepository = getSessionRepository();
        final Session sessionInBase = sessionRepository.getById(session.getId());
        if (sessionInBase == null || !sessionInBase.getSignature().equals(session.getSignature())) {
            //Session is not in a repository OR Signature is incorrect
            throw new UncorrectSessionException();
        }
        if (System.currentTimeMillis() - session.getTimeStamp().getTime() > SESSION_LIFETIME) {
            //Session is correct, but older than SessionLifeTime
            sessionRepository.getTransaction().begin();
            sessionRepository.delete(session);
            sessionRepository.close();
            throw new UncorrectSessionException();
        }
        sessionRepository.close();
    }

    private String createSaltHashSignature(String id) {
        String signature = DigestUtils.md5Hex(id);
        for (int i = 0; i < SALT_COUNTER; i++) {
            signature = DigestUtils.md5Hex(signature + SECRET_KEY);
        }
        return signature;
    }
}

