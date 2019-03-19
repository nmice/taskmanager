package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.entity.Project;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {

    @Inject
    private IProjectRepository projectRepository;

    @WebMethod
    public void projectMerge(@WebParam(name = "project") Project project) {
        projectRepository.merge(project);
    }

    @WebMethod
    public Project projectGetById(@WebParam(name = "id") String id) {
        return projectRepository.findBy(id);
    }

    @WebMethod
    public List<Project> projectGetAll() {
        return projectRepository.findAll();
    }

    @WebMethod
    public void projectDelete(@WebParam(name = "id") String id) {
        projectRepository.remove(projectRepository.findBy(id));
    }
}
