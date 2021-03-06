package ru.neginskiy.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-03-15T12:14:35.640+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.neginskiy.ru/", name = "ProjectEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectEndpoint {

    @WebMethod
    @RequestWrapper(localName = "projectGetById", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectGetById")
    @ResponseWrapper(localName = "projectGetByIdResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectGetByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Project projectGetById(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @RequestWrapper(localName = "projectDelete", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectDelete")
    @ResponseWrapper(localName = "projectDeleteResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectDeleteResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.neginskiy.tm.endpoint.Project projectDelete(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @RequestWrapper(localName = "projectMerge", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectMerge")
    @ResponseWrapper(localName = "projectMergeResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectMergeResponse")
    public void projectMerge(
        @WebParam(name = "project", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Project project
    );

    @WebMethod
    @RequestWrapper(localName = "projectGetAll", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectGetAll")
    @ResponseWrapper(localName = "projectGetAllResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.ProjectGetAllResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.neginskiy.tm.endpoint.Project> projectGetAll();
}
