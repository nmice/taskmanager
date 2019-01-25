package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ISessionService;
import ru.neginskiy.tm.entity.Session;

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
    public void sessionMerge(@WebParam(name = "user") Session session) {
        sessionService.merge(session);
    }

    @WebMethod
    public Session sessionGetById(@WebParam(name = "id") String id) {
        return sessionService.getById(id);
    }

    @WebMethod
    public Session sessionDelete(@WebParam(name = "id") String id) {
        return sessionService.delete(id);
    }

    @WebMethod
    public Session getNewSession(@WebParam(name = "userId") String userId) {
        return sessionService.getNewSession(userId);
    }
}
