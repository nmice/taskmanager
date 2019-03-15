package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.UserRepository;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class UserEndpoint {

    @Inject
    private UserRepository userRepository;

    @WebMethod
    public void userMerge(@WebParam(name = "user") User user) {
        userRepository.merge(user);
    }

    @WebMethod
    public boolean isRegistredLogin(@WebParam(name = "login") String login) {
        return userRepository.isRegistredLogin(login);
    }

    @WebMethod
    public User findUser(@WebParam(name = "login") String login,
                         @WebParam(name = "password") String password) {
        return userRepository.findUser(login, password);
    }
}
