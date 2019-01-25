package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.IProjectService;
import ru.neginskiy.tm.entity.Project;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {

    private IProjectService projectService;

    public ProjectEndpoint(IProjectService projectService) {
        this.projectService = projectService;
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
