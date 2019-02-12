package ru.neginskiy.tm.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.neginskiy.tm.api.repository.ISessionRepository;
import ru.neginskiy.tm.api.service.ISessionService;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.error.UncorrectSessionException;
import ru.neginskiy.tm.util.AppConfig;

import java.util.List;

public class SessionService implements ISessionService {

    private final SqlSessionFactory sqlSessionFactory;

    private static final int SESSION_LIFETIME = AppConfig.sessionLifetime;
    private static final String SECRET_KEY = AppConfig.secretKey;
    private static final int SALT_COUNTER = AppConfig.saltCounter;

    public SessionService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Session getNewSession(String userId) {
        if (userId == null) {
            return null;
        }
        final SqlSession sqlSession = sqlSessionFactory.openSession();
        final ISessionRepository sessionMapper = sqlSession.getMapper(ISessionRepository.class);
        final List<Session> sessionList = sessionMapper.getAllByUserId(userId);
        for (Session session : sessionList) {
            if (System.currentTimeMillis() - session.getTimeStamp().getTime() > SESSION_LIFETIME) {
                delete(session.getId());
            }
        }
        final Session session = new Session();
        session.setUserId(userId);
        String signature = DigestUtils.md5Hex(session.getId());
        for (int i = 0; i < SALT_COUNTER; i++) {
            signature = DigestUtils.md5Hex(signature + SECRET_KEY);
        }
        session.setSignature(signature);
        sessionMapper.merge(session);
        sqlSession.commit();
        sqlSession.close();
        return session;
    }

    @Override
    public Session delete(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final SqlSession sqlSession = sqlSessionFactory.openSession();
        final ISessionRepository sessionMapper = sqlSession.getMapper(ISessionRepository.class);
        final Session session = sessionMapper.getById(id);
        if (session == null) {
            return null;
        }
        int counter = sessionMapper.delete(id);
        if (counter == 0) {
            return null;
        }
        sqlSession.commit();
        sqlSession.close();
        return session;
    }


    @Override
    public void validate(Session session) throws UncorrectSessionException {
        if (session == null) {
            throw new UncorrectSessionException();
        }
        final SqlSession sqlSession = sqlSessionFactory.openSession();
        final ISessionRepository sessionMapper = sqlSession.getMapper(ISessionRepository.class);
        final Session sessionInBase = sessionMapper.getById(session.getId());
        if (sessionInBase == null || !sessionInBase.getSignature().equals(session.getSignature())) {//Session is not in a repository OR Signature is incorrect
            throw new UncorrectSessionException();
        }
        if (System.currentTimeMillis() - session.getTimeStamp().getTime() > SESSION_LIFETIME) {//Session is correct, but older than 30min
            delete(session.getId());
            throw new UncorrectSessionException();
        }
    }
}

