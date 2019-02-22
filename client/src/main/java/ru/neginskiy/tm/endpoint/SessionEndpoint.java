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
 * 2019-02-22T15:24:43.499+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.neginskiy.ru/", name = "SessionEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface SessionEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/getNewSessionRequest", output = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/getNewSessionResponse")
    @RequestWrapper(localName = "getNewSession", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.GetNewSession")
    @ResponseWrapper(localName = "getNewSessionResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.GetNewSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Session getNewSession(
        @WebParam(name = "user", targetNamespace = "")
        ru.neginskiy.tm.endpoint.User user
    );
}
