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
 * 2019-01-28T13:43:14.854+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.neginskiy.ru/", name = "ProjectEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/ProjectEndpoint/projectGetByIdRequest", output = "http://endpoint.tm.neginskiy.ru/ProjectEndpoint/projectGetByIdResponse")
    @RequestWrapper(localName = "projectGetById", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectGetById")
    @ResponseWrapper(localName = "projectGetByIdResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectGetByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Project projectGetById(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/ProjectEndpoint/projectDeleteRequest", output = "http://endpoint.tm.neginskiy.ru/ProjectEndpoint/projectDeleteResponse")
    @RequestWrapper(localName = "projectDelete", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectDelete")
    @ResponseWrapper(localName = "projectDeleteResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectDeleteResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Project projectDelete(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/ProjectEndpoint/projectGetAllByUserIdRequest", output = "http://endpoint.tm.neginskiy.ru/ProjectEndpoint/projectGetAllByUserIdResponse")
    @RequestWrapper(localName = "projectGetAllByUserId", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectGetAllByUserId")
    @ResponseWrapper(localName = "projectGetAllByUserIdResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectGetAllByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.neginskiy.tm.endpoint.Project> projectGetAllByUserId(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/ProjectEndpoint/projectMergeRequest", output = "http://endpoint.tm.neginskiy.ru/ProjectEndpoint/projectMergeResponse")
    @RequestWrapper(localName = "projectMerge", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectMerge")
    @ResponseWrapper(localName = "projectMergeResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectMergeResponse")
    public void projectMerge(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "project", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Project project
    );
}
