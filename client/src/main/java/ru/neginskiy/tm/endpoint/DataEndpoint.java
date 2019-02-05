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
 * 2019-02-05T18:32:17.234+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.neginskiy.ru/", name = "DataEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface DataEndpoint {

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
    @Action(input = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataBinRequest", output = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataBinResponse", fault = {@FaultAction(className = UncorrectSessionException_Exception.class, value = "http://endpoint.tm.neginskiy.ru/DataEndpoint/loadDataBin/Fault/UncorrectSessionException")})
    @RequestWrapper(localName = "loadDataBin", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.LoadDataBin")
    @ResponseWrapper(localName = "loadDataBinResponse", targetNamespace = "http://endpoint.tm.neginskiy.ru/", className = "ru.neginskiy.tm.endpoint.LoadDataBinResponse")
    public void loadDataBin(
        @WebParam(name = "session", targetNamespace = "")
        ru.neginskiy.tm.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    ) throws UncorrectSessionException_Exception;
}
