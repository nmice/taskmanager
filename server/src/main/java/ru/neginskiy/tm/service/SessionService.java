package ru.neginskiy.tm.service;

import org.apache.commons.codec.digest.DigestUtils;
import ru.neginskiy.tm.api.ISessionService;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.repository.SessionRepository;

import java.io.InputStream;
import java.util.Properties;

public class SessionService implements ISessionService {

    private final SessionRepository entityRepository;

    public SessionService(SessionRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    private static final int SALT_COUNTER = 1000;

    private static final String PROPERTY_FILE = "/config.properties";

    private final String SECRET_KEY = "secretKey";

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
        try {
            final InputStream is = getClass().getResourceAsStream(PROPERTY_FILE);
            final Properties properties = new Properties();
            properties.load(is);
            final String secretKey = properties.getProperty(SECRET_KEY);

            String signature = DigestUtils.md5Hex(session.getId());
            for (int i = 0; i < SALT_COUNTER; i++) {
                signature = DigestUtils.md5Hex(signature + secretKey);
            }
            session.setSignature(signature);
            merge(session);//Add to Session repository
            return session;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean isUncorrectSession(Session session) {
        if (session == null) {
            return true;
        }
        return entityRepository.isUncorrectSession(session);
    }

}
