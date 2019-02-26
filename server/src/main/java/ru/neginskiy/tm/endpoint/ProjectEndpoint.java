package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.error.UncorrectSessionException;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {

    @Inject
    private ServiceLocator serviceLocator;

    @WebMethod
    public void projectMerge(@WebParam(name = "session") Session session,
                             @WebParam(name = "project") Project project) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().merge(project);
    }

    @WebMethod
    public Project projectGetById(@WebParam(name = "session") Session session,
                                  @WebParam(name = "id") String id) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getProjectService().getById(id);
    }

    @WebMethod
    public List<Project> projectGetAllByUserId(@WebParam(name = "session") Session session,
                                               @WebParam(name = "userId") String userId) throws UncorrectSessionException {

        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getProjectService().getAllByUserId(userId);
    }

    @WebMethod
    public Project projectDelete(@WebParam(name = "session") Session session,
                                 @WebParam(name = "id") String id) throws UncorrectSessionException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getProjectService().delete(id);
    }
}
