package ru.neginskiy.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-13T11:31:35.057+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.neginskiy.ru/", name = "UserEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface UserEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/UserEndpoint/userMergeRequest", output = "http://endpoint.tm.neginskiy.ru/UserEndpoint/userMergeResponse")
    @RequestWrapper(localName = "userMerge", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.UserMerge")
    @ResponseWrapper(localName = "userMergeResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.UserMergeResponse")
    public void userMerge(
        @WebParam(name = "user", targetNamespace = "")
        ru.neginskiy.tm.endpoint.User user
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/UserEndpoint/isRegistredLoginRequest", output = "http://endpoint.tm.neginskiy.ru/UserEndpoint/isRegistredLoginResponse")
    @RequestWrapper(localName = "isRegistredLogin", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.IsRegistredLogin")
    @ResponseWrapper(localName = "isRegistredLoginResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.IsRegistredLoginResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean isRegistredLogin(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/UserEndpoint/findUserRequest", output = "http://endpoint.tm.neginskiy.ru/UserEndpoint/findUserResponse")
    @RequestWrapper(localName = "findUser", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.FindUser")
    @ResponseWrapper(localName = "findUserResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.FindUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.User findUser(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "passwordHash", targetNamespace = "")
        java.lang.String passwordHash
    );
}
