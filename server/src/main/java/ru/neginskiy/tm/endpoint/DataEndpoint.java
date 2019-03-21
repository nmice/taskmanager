package ru.neginskiy.tm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.error.UncorrectSessionException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Component
@WebService
public class DataEndpoint {

    @Autowired
    private ServiceLocator serviceLocator;

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
