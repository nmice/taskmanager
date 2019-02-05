package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ISessionService;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.error.UncorrectSessionException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SessionEndpoint {

    private ISessionService sessionService;

    public SessionEndpoint(ISessionService sessionService) {
        this.sessionService = sessionService;
    }

    @WebMethod
    public Session sessionDelete(@WebParam(name = "session") Session session) {
        try {
            sessionService.validate(session);
        } catch (UncorrectSessionException e) {
            return null;
        }
        return sessionService.delete(session.getId());
    }

    @WebMethod
    public Session getNewSession(@WebParam(name = "userId") String userId) {
        return sessionService.getNewSession(userId);
    }

/*    @WebMethod
    public void validate(@WebParam(name = "session") Session session) throws UncorrectSessionException {
        sessionService.validate(session);
    }*/
}
