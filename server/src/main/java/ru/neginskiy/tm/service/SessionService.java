package ru.neginskiy.tm.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${sessionLifetime}")
    private String SESSION_LIFETIME;

    @Value("${secretKey}")
    private String SECRET_KEY;

    @Value("${saltCounter}")
    private String SALT_COUNTER;

    @Override
    public @Nullable Session getNewSession(@Nullable User user) {
        if (user == null) {
            return null;
        }
        //Delete old session by User
        final List<Session> sessionList = sessionRepository.getAllByUserId(user.getId());
        final int sessionLifeTime = Integer.parseInt(SESSION_LIFETIME);
        for (Session session : sessionList) {
            if (System.currentTimeMillis() - session.getTimeStamp().getTime() > sessionLifeTime) {
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
        final int sessionLifeTime = Integer.parseInt(SESSION_LIFETIME);
        if (System.currentTimeMillis() - sessionInBase.getTimeStamp().getTime() > sessionLifeTime) {
            //Session is correct, but older than SessionLifeTime
            sessionRepository.delete(sessionInBase);
            throw new UncorrectSessionException();
        }
    }

    private String createSaltHashSignature(String id) {
        String signature = DigestUtils.md5Hex(id);
        final int saltCounter = Integer.parseInt(SALT_COUNTER);
        for (int i = 0; i < saltCounter; i++) {
            signature = DigestUtils.md5Hex(signature + SECRET_KEY);
        }
        return signature;
    }
}

