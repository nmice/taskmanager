package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.error.UncorrectSessionException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SessionEndpoint {

    private ServiceLocator serviceLocator;

    public SessionEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    public Session sessionDelete(@WebParam(name = "session") Session session) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getSessionService().delete(session.getId());
    }

    @WebMethod
    public Session getNewSession(@WebParam(name = "user") User user) {
        return serviceLocator.getSessionService().getNewSession(user);
    }
}
