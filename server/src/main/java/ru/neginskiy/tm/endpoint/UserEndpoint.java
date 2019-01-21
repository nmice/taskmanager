package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.service.UserService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class UserEndpoint {

    private UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @WebMethod
    public void merge(@WebParam(name = "user") User user) {
        userService.merge(user);
    }

    @WebMethod
    public User getById(@WebParam(name = "id") String id) {
        return userService.getById(id);
    }

    @WebMethod
    public List<User> getAll() {
        return userService.getAll();
    }

    @WebMethod
    public User delete(@WebParam(name = "id") String id) {
        return userService.delete(id);
    }
}
