package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.repository.ProjectRepository;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {

    @Inject
    private ProjectRepository projectRepository;

    @WebMethod
    public void projectMerge(@WebParam(name = "project") Project project) {
        projectRepository.merge(project);
    }

    @WebMethod
    public Project projectGetById(@WebParam(name = "id") String id) {
        return projectRepository.getById(id);
    }

    @WebMethod
    public List<Project> projectGetAllByUserId() {
        return projectRepository.getAll();
    }

    @WebMethod
    public Project projectDelete(@WebParam(name = "id") String id) {
        return projectRepository.delete(id);
    }
}
