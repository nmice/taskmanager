package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.error.UncorrectSessionException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class DataEndpoint {

    private ServiceLocator serviceLocator;

    public DataEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    public void saveDataBin(@WebParam(name = "session") Session session,
                            @WebParam(name = "userId") String userId) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getDataService().saveDataBin(userId);
    }

    @WebMethod
    public void loadDataBin(@WebParam(name = "session") Session session,
                            @WebParam(name = "userId") String userId) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getDataService().loadDataBin(userId);
    }

    @WebMethod
    public void saveDataJson(@WebParam(name = "session") Session session,
                             @WebParam(name = "userId") String userId) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getDataService().saveDataJson(userId);
    }

    @WebMethod
    public void loadDataJson(@WebParam(name = "session") Session session,
                             @WebParam(name = "userId") String userId) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getDataService().loadDataJson(userId);
    }

    @WebMethod
    public void saveDataXml(@WebParam(name = "session") Session session,
                             @WebParam(name = "userId") String userId) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getDataService().saveDataXml(userId);
    }

    @WebMethod
    public void loadDataXml(@WebParam(name = "session") Session session,
                             @WebParam(name = "userId") String userId) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getDataService().loadDataXml(userId);
    }

}
