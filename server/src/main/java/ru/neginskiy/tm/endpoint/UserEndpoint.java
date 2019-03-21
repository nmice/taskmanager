package ru.neginskiy.tm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Component
@WebService
public class UserEndpoint {

    @Autowired
    private ServiceLocator serviceLocator;

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
