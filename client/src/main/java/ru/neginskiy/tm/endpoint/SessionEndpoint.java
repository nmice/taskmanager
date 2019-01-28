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
 * 2019-01-28T13:43:15.186+03:00
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
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session
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
    @Action(input = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/isUncorrectSessionRequest", output = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/isUncorrectSessionResponse")
    @RequestWrapper(localName = "isUncorrectSession", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.IsUncorrectSession")
    @ResponseWrapper(localName = "isUncorrectSessionResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.IsUncorrectSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean isUncorrectSession(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/getNewSessionRequest", output = "http://endpoint.tm.neginskiy.ru/SessionEndpoint/getNewSessionResponse")
    @RequestWrapper(localName = "getNewSession", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.GetNewSession")
    @ResponseWrapper(localName = "getNewSessionResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.GetNewSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Session getNewSession(
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    );

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
