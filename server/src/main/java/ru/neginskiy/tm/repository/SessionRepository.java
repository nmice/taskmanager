package ru.neginskiy.tm.repository;

import org.apache.commons.codec.digest.DigestUtils;
import ru.neginskiy.tm.entity.Session;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SessionRepository extends AbstractRepository<Session> {

    private static final int SALT_COUNTER = 1000;
    private static final int SESSION_LIFETIME = 1800_000;//30 minutes

    public Session getNewSession(String userId) {
        Session session = new Session();
        session.setUserId(userId);
        try {
            File file = new File(("src/main/resources/config.properties"));
            Properties properties = new Properties();
            properties.load(new FileReader(file));
            String secretKey = properties.getProperty("secretKey");
            String signature = DigestUtils.md5Hex(session.getId());
            for (int i = 0; i < SALT_COUNTER; i++) {
                signature = DigestUtils.md5Hex(signature + secretKey);
            }
            session.setSignature(signature);
            merge(session);//Add to Session repository
            return session;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isUncorrectSession(Session session) {
        Session sessionInRepo = getById(session.getId());
        if (sessionInRepo == null || !sessionInRepo.getSignature().equals(session.getSignature())) {//Session is not in a repository OR Signature is incorrect
            return true;
        }
        if (System.currentTimeMillis() - session.getTimeStamp().getTime() > SESSION_LIFETIME) {//Session is correct, but older than 30min
            delete(session.getId());
            return true;
        }
        return false;
    }
}
