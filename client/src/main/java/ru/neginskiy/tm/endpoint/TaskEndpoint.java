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
 * 2019-01-28T13:43:14.666+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.neginskiy.ru/", name = "TaskEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface TaskEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/TaskEndpoint/taskGetAllByUserIdRequest", output = "http://endpoint.tm.neginskiy.ru/TaskEndpoint/taskGetAllByUserIdResponse")
    @RequestWrapper(localName = "taskGetAllByUserId", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.TaskGetAllByUserId")
    @ResponseWrapper(localName = "taskGetAllByUserIdResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.TaskGetAllByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.neginskiy.tm.endpoint.Task> taskGetAllByUserId(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/TaskEndpoint/taskMergeRequest", output = "http://endpoint.tm.neginskiy.ru/TaskEndpoint/taskMergeResponse")
    @RequestWrapper(localName = "taskMerge", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.TaskMerge")
    @ResponseWrapper(localName = "taskMergeResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.TaskMergeResponse")
    public void taskMerge(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "task", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Task task
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/TaskEndpoint/taskGetByIdRequest", output = "http://endpoint.tm.neginskiy.ru/TaskEndpoint/taskGetByIdResponse")
    @RequestWrapper(localName = "taskGetById", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.TaskGetById")
    @ResponseWrapper(localName = "taskGetByIdResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.TaskGetByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Task taskGetById(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/TaskEndpoint/taskDeleteRequest", output = "http://endpoint.tm.neginskiy.ru/TaskEndpoint/taskDeleteResponse")
    @RequestWrapper(localName = "taskDelete", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.TaskDelete")
    @ResponseWrapper(localName = "taskDeleteResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.TaskDeleteResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Task taskDelete(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );
}
