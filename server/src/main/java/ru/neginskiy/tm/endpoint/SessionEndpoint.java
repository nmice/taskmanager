package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.User;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SessionEndpoint {

    @Inject
    private ServiceLocator serviceLocator;

    @WebMethod
    public Session getNewSession(@WebParam(name = "user") User user) {
        return serviceLocator.getSessionService().getNewSession(user);
    }
}
