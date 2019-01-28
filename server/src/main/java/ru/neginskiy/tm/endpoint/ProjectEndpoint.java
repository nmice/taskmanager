package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.IProjectService;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Project;

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
    public void projectMerge(@WebParam(name = "project") Project project) {
        serviceLocator.getProjectService().merge(project);
    }

    @WebMethod
    public Project projectGetById(@WebParam(name = "id") String id) {
        return serviceLocator.getProjectService().getById(id);
    }

    @WebMethod
    public List<Project> projectGetAllByUserId(@WebParam(name = "userId") String userId) {
        return serviceLocator.getProjectService().getAllByUserId(userId);
    }

    @WebMethod
    public Project projectDelete(@WebParam(name = "id") String id) {
        return serviceLocator.getProjectService().delete(id);
    }
}
