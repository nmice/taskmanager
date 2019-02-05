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
    public void saveDataBin (@WebParam(name = "session") Session session,
                             @WebParam(name = "userId") String userId){
        try {
            serviceLocator.getSessionService().validate(session);
        } catch (UncorrectSessionException e) {
            return;
        }
        serviceLocator.getDataService().saveDataBin(userId);
    }

    @WebMethod
    public void loadDataBin (@WebParam(name = "session") Session session,
                             @WebParam(name = "userId") String userId){
        try {
            serviceLocator.getSessionService().validate(session);
        } catch (UncorrectSessionException e) {
            return;
        }
        serviceLocator.getDataService().loadDataBin(userId);
    }
}
