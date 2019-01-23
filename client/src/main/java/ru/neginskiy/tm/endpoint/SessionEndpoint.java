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
 * 2019-01-23T17:16:04.925+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.neginskiy.ru/", name = "SessionEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface SessionEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/sessionMergeRequest", output = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/sessionMergeResponse")
    @RequestWrapper(localName = "sessionMerge", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SessionMerge")
    @ResponseWrapper(localName = "sessionMergeResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SessionMergeResponse")
    public void sessionMerge(
        @WebParam(name = "user", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session user
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/sessionGetByIdRequest", output = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/sessionGetByIdResponse")
    @RequestWrapper(localName = "sessionGetById", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SessionGetById")
    @ResponseWrapper(localName = "sessionGetByIdResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SessionGetByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Session sessionGetById(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/sessionGetAllRequest", output = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/sessionGetAllResponse")
    @RequestWrapper(localName = "sessionGetAll", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SessionGetAll")
    @ResponseWrapper(localName = "sessionGetAllResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SessionGetAllResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.neginskiy.tm.endpoint.Session> sessionGetAll();

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/sessionDeleteRequest", output = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/sessionDeleteResponse")
    @RequestWrapper(localName = "sessionDelete", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SessionDelete")
    @ResponseWrapper(localName = "sessionDeleteResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SessionDeleteResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Session sessionDelete(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );
}
