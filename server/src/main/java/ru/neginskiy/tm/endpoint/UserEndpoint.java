package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.NoResultException;

@WebService
public class UserEndpoint {

    private IUserService userService;

    public UserEndpoint(IUserService userService) {
        this.userService = userService;
    }

    @WebMethod
    public void userMerge(@WebParam(name = "user") User user) {
        userService.merge(user);
    }


    @WebMethod
    public boolean isRegistredLogin(@WebParam(name = "login") String login) {
        return userService.isRegistredLogin(login);
    }

    @WebMethod
    public User findUser(@WebParam(name = "login") String login,
                         @WebParam(name = "passwordHash") String passwordHash) {
        return userService.findUser(login, passwordHash);
    }
}
