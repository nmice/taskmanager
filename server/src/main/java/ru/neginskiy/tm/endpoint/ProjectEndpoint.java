package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.service.ProjectService;
import ru.neginskiy.tm.service.SessionService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {

    private ProjectService projectService;
    private SessionService sessionService;

    public ProjectEndpoint(ProjectService projectService, SessionService sessionService) {
        this.projectService = projectService;
        this.sessionService = sessionService;
    }

    @WebMethod
    public void projectMerge(@WebParam(name = "project") Project project) {
        projectService.merge(project);
    }

    @WebMethod
    public Project projectGetById(@WebParam(name = "id") String id) {
        return projectService.getById(id);
    }

    @WebMethod
    public List<Project> projectGetAllByUserId(@WebParam(name = "userId") String userId) {
        return projectService.getAllByUserId(userId);
    }

    @WebMethod
    public Project projectDelete(@WebParam(name = "id") String id) {
        return projectService.delete(id);
    }
}
