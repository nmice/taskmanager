package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.error.UncorrectSessionException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class UserEndpoint {

    private ServiceLocator serviceLocator;

    public UserEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    public void userMerge(@WebParam(name = "user") User user) {
        serviceLocator.getUserService().merge(user);
    }

    @WebMethod
    public boolean isRegistredLogin(@WebParam(name = "login") String login) {
        return serviceLocator.getUserService().isRegistredLogin(login);
    }

    @WebMethod
    public User findUser(@WebParam(name = "login") String login,
                         @WebParam(name = "passwordHash") String passwordHash) {
        return serviceLocator.getUserService().findUser(login, passwordHash);
    }
}
