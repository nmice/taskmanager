package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.error.UncorrectSessionException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskEndpoint {

    private ServiceLocator serviceLocator;

    public TaskEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    public void taskMerge(@WebParam(name = "session") Session session,
                          @WebParam(name = "task") Task task) {
        try {
            serviceLocator.getSessionService().validate(session);
        } catch (UncorrectSessionException e) {
            return;
        }
        serviceLocator.getTaskService().merge(task);
    }

    @WebMethod
    public Task taskGetById(@WebParam(name = "session") Session session,
                            @WebParam(name = "id") String id) {
        try {
            serviceLocator.getSessionService().validate(session);
        } catch (UncorrectSessionException e) {
            return null;
        }
        return serviceLocator.getTaskService().getById(id);
    }

    @WebMethod
    public List<Task> taskGetAllByUserId(@WebParam(name = "session") Session session,
                                         @WebParam(name = "userId") String userId) {
        try {
            serviceLocator.getSessionService().validate(session);
        } catch (UncorrectSessionException e) {
            return null;
        }
        return serviceLocator.getTaskService().getAllByUserId(userId);
    }

    @WebMethod
    public Task taskDelete(@WebParam(name = "session") Session session,
                           @WebParam(name = "id") String id) {
        try {
            serviceLocator.getSessionService().validate(session);
        } catch (UncorrectSessionException e) {
            return null;
        }
        return serviceLocator.getTaskService().delete(id);
    }
}
