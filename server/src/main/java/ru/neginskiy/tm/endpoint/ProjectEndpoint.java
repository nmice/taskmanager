package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.IProjectService;
import ru.neginskiy.tm.api.ISessionService;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {

    private IProjectService projectService;
    private ISessionService sessionService;

    public ProjectEndpoint(IProjectService projectService, ISessionService sessionService) {
        this.projectService = projectService;
        this.sessionService = sessionService;
    }

    @WebMethod
    public void projectMerge(@WebParam(name = "session") Session session,
                             @WebParam(name = "project") Project project) {
        projectService.merge(project);
    }

    @WebMethod
    public Project projectGetById(@WebParam(name = "session") Session session,
                                  @WebParam(name = "id") String id) {
        return projectService.getById(id);
    }

    @WebMethod
    public List<Project> projectGetAllByUserId(@WebParam(name = "session") Session session,
                                               @WebParam(name = "userId") String userId) {
        return projectService.getAllByUserId(userId);
    }

    @WebMethod
    public Project projectDelete(@WebParam(name = "session") Session session,
                                 @WebParam(name = "id") String id) {
        return projectService.delete(id);
    }
}
