package ru.neginskiy.tm.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.ServiceLocator;
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

    @Override
    public @Nullable Session getNewSession(@Nullable User user) {
        if (user == null) {
            return null;
        }
        //Delete old session by user:
        List<Session> sessionList = sessionRepository.getAllByUserId(user.getId());
        for (Session session : sessionList) {
            if (System.currentTimeMillis() - session.getTimeStamp().getTime() > SESSION_LIFETIME) {
                sessionRepository.delete(session);
            }
        }
        //Create new Session:
        final Session session = new Session();
        session.setUser(user);
        String signature = DigestUtils.md5Hex(session.getId());
        for (int i = 0; i < SALT_COUNTER; i++) {
            signature = DigestUtils.md5Hex(signature + SECRET_KEY);
        }
        session.setSignature(signature);
        sessionRepository.merge(session);
        return session;
    }

    @Override
    public @Nullable Session delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        Session session = sessionRepository.getById(id);
        sessionRepository.delete(session);
        return session;
    }

    @Override
    public void validate(@Nullable Session session) throws UncorrectSessionException {
        if (session == null) {
            throw new UncorrectSessionException();
        }
        final Session sessionInBase = sessionRepository.getById(session.getId());
        if (sessionInBase == null || !sessionInBase.getSignature().equals(session.getSignature())) {//Session is not in a repository OR Signature is incorrect
            throw new UncorrectSessionException();
        }
        if (System.currentTimeMillis() - session.getTimeStamp().getTime() > SESSION_LIFETIME) {//Session is correct, but older than 30min
            sessionRepository.delete(session);
            throw new UncorrectSessionException();
        }
    }
}

