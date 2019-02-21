package ru.neginskiy.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-21T11:11:50.840+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.neginskiy.ru/", name = "DataEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface DataEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataXmlRequest", output = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataXmlResponse", fault = {@FaultAction(className = UncorrectSessionException_Exception.class, value = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataXml/Fault/UncorrectSessionException")})
    @RequestWrapper(localName = "loadDataXml", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.LoadDataXml")
    @ResponseWrapper(localName = "loadDataXmlResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.LoadDataXmlResponse")
    public void loadDataXml(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    ) throws UncorrectSessionException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataBinRequest", output = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataBinResponse", fault = {@FaultAction(className = UncorrectSessionException_Exception.class, value = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataBin/Fault/UncorrectSessionException")})
    @RequestWrapper(localName = "loadDataBin", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.LoadDataBin")
    @ResponseWrapper(localName = "loadDataBinResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.LoadDataBinResponse")
    public void loadDataBin(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    ) throws UncorrectSessionException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/DataEndpoint/saveDataBinRequest", output = "http://endpoint.tm.neginskiy.ru/DataEndpoint/saveDataBinResponse", fault = {@FaultAction(className = UncorrectSessionException_Exception.class, value = "http://endpoint.tm.neginskiy.ru/DataEndpoint/saveDataBin/Fault/UncorrectSessionException")})
    @RequestWrapper(localName = "saveDataBin", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SaveDataBin")
    @ResponseWrapper(localName = "saveDataBinResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SaveDataBinResponse")
    public void saveDataBin(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    ) throws UncorrectSessionException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/DataEndpoint/saveDataXmlRequest", output = "http://endpoint.tm.neginskiy.ru/DataEndpoint/saveDataXmlResponse", fault = {@FaultAction(className = UncorrectSessionException_Exception.class, value = "http://endpoint.tm.neginskiy.ru/DataEndpoint/saveDataXml/Fault/UncorrectSessionException")})
    @RequestWrapper(localName = "saveDataXml", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SaveDataXml")
    @ResponseWrapper(localName = "saveDataXmlResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SaveDataXmlResponse")
    public void saveDataXml(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    ) throws UncorrectSessionException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataJsonRequest", output = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataJsonResponse", fault = {@FaultAction(className = UncorrectSessionException_Exception.class, value = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataJson/Fault/UncorrectSessionException")})
    @RequestWrapper(localName = "loadDataJson", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.LoadDataJson")
    @ResponseWrapper(localName = "loadDataJsonResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.LoadDataJsonResponse")
    public void loadDataJson(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    ) throws UncorrectSessionException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.neginskiy.ru/DataEndpoint/saveDataJsonRequest", output = "http://endpoint.tm.neginskiy.ru/DataEndpoint/saveDataJsonResponse", fault = {@FaultAction(className = UncorrectSessionException_Exception.class, value = "http://endpoint.tm.neginskiy.ru/DataEndpoint/saveDataJson/Fault/UncorrectSessionException")})
    @RequestWrapper(localName = "saveDataJson", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SaveDataJson")
    @ResponseWrapper(localName = "saveDataJsonResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.SaveDataJsonResponse")
    public void saveDataJson(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    ) throws UncorrectSessionException_Exception;
}
