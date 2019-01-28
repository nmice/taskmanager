package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {

    private ServiceLocator serviceLocator;

    public ProjectEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    public void projectMerge(@WebParam(name = "session") Session session,
                             @WebParam(name = "project") Project project) {
        if (serviceLocator.getSessionService().isUncorrectSession(session)) {
            return;
        }
        serviceLocator.getProjectService().merge(project);
    }

    @WebMethod
    public Project projectGetById(@WebParam(name = "session") Session session,
                                  @WebParam(name = "id") String id) {
        if (serviceLocator.getSessionService().isUncorrectSession(session)) {
            return null;
        }
        return serviceLocator.getProjectService().getById(id);
    }

    @WebMethod
    public List<Project> projectGetAllByUserId(@WebParam(name = "session") Session session,
                                               @WebParam(name = "userId") String userId) {
        if (serviceLocator.getSessionService().isUncorrectSession(session)) {
            return null;
        }
        return serviceLocator.getProjectService().getAllByUserId(userId);
    }

    @WebMethod
    public Project projectDelete(@WebParam(name = "session") Session session,
                                 @WebParam(name = "id") String id) {
        if (serviceLocator.getSessionService().isUncorrectSession(session)) {
            return null;
        }
        return serviceLocator.getProjectService().delete(id);
    }
}
