package ru.neginskiy.tm.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neginskiy.tm.api.repository.ISessionRepository;
import ru.neginskiy.tm.api.service.ISessionService;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.error.UncorrectSessionException;
import ru.neginskiy.tm.util.AppConfig;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Transactional
@Service
public class SessionService implements ISessionService {

    @Autowired
    private ISessionRepository sessionRepository;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    private static final int SESSION_LIFETIME = AppConfig.sessionLifetime;
    private static final String SECRET_KEY = AppConfig.secretKey;
    private static final int SALT_COUNTER = AppConfig.saltCounter;

    @Override
    public @Nullable Session getNewSession(@Nullable User user) {
        if (user == null) {
            return null;
        }
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
        sessionRepository.save(session);
        return session;
    }

    @Override
    public void validate(@Nullable Session session) throws UncorrectSessionException {
        if (session == null) {
            throw new UncorrectSessionException();
        }
        final Session sessionInBase = sessionRepository.getOne(session.getId());
        if (sessionInBase == null || !sessionInBase.getSignature().equals(session.getSignature())) {
            //Session is not in a repository OR Signature is incorrect
            throw new UncorrectSessionException();
        }
        if (System.currentTimeMillis() - sessionInBase.getTimeStamp().getTime() > SESSION_LIFETIME) {
            //Session is correct, but older than SessionLifeTime
            sessionRepository.delete(sessionInBase);
            throw new UncorrectSessionException();
        }
    }

    private String createSaltHashSignature(String id) {
        String signature = DigestUtils.md5Hex(id);
        for (int i = 0; i < SALT_COUNTER; i++) {
            signature = DigestUtils.md5Hex(signature + SECRET_KEY);
        }
        return signature;
    }
}

