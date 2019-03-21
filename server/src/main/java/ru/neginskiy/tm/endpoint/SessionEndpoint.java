package ru.neginskiy.tm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Component
@WebService
public class SessionEndpoint {

    @Autowired
    private ServiceLocator serviceLocator;

    @WebMethod
    public Session getNewSession(@WebParam(name = "user") User user) {
        return serviceLocator.getSessionService().getNewSession(user);
    }
}
