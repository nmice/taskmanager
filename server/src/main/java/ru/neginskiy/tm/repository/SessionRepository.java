package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.Session;

public class SessionRepository extends AbstractRepository<Session> {

    private static final int SESSION_LIFETIME = 1800_000;//30 minutes

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
