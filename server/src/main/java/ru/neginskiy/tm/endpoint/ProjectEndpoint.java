package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.service.ProjectService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {

    private ProjectService projectService;

    public ProjectEndpoint(ProjectService projectService) {
        this.projectService = projectService;
    }

    @WebMethod
    public void merge(@WebParam(name = "project") Project project) {
        projectService.merge(project);
    }

    @WebMethod
    public Project getById(@WebParam(name = "id") String id) {
        return projectService.getById(id);
    }

    @WebMethod
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @WebMethod
    public Project delete(@WebParam(name = "id") String id) {
        return projectService.delete(id);
    }
}
