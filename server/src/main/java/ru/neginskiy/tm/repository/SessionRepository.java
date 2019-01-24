package ru.neginskiy.tm.repository;

import org.apache.commons.codec.digest.DigestUtils;
import ru.neginskiy.tm.entity.Session;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SessionRepository extends AbstractRepository<Session> {

    public static final int SALT_COUNTER = 1000;

    public Session getNewSession(String userId) {
        Session session = new Session();
        session.setUserId(userId);

        File file = new File(("src/main/resources/config.properties"));
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
            String secretKey = properties.getProperty("secretKey");
            String signature = session.getId();
            for (int i = 0; i < SALT_COUNTER; i++){
                signature += DigestUtils.md5Hex(session.getId()) + secretKey;
            }
            session.setSignature(signature);

            return session;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
