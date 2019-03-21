package ru.neginskiy.tm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.error.UncorrectSessionException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService
public class TaskEndpoint {

    @Autowired
    private ServiceLocator serviceLocator;

    @WebMethod
    public void taskMerge(@WebParam(name = "session") Session session,
                          @WebParam(name = "task") Task task) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getTaskService().merge(task);
    }

    @WebMethod
    public Task taskGetById(@WebParam(name = "session") Session session,
                            @WebParam(name = "id") String id) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getTaskService().getById(id);
    }

    @WebMethod
    public List<Task> taskGetAllByUserId(@WebParam(name = "session") Session session,
                                         @WebParam(name = "userId") String userId) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getTaskService().getAllByUserId(userId);
    }

    @WebMethod
    public Task taskDelete(@WebParam(name = "session") Session session,
                           @WebParam(name = "id") String id) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getTaskService().delete(id);
    }
}
