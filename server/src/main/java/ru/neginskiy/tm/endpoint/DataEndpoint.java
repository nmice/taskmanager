package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Session;

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
        if (serviceLocator.getSessionService().isUncorrectSession(session)) {
            return;
        }
        serviceLocator.getDataService().saveDataBin(userId);
    }

    @WebMethod
    public void loadDataBin (@WebParam(name = "session") Session session,
                             @WebParam(name = "userId") String userId){
        if (serviceLocator.getSessionService().isUncorrectSession(session)) {
            return;
        }
        serviceLocator.getDataService().loadDataBin(userId);
    }
}
