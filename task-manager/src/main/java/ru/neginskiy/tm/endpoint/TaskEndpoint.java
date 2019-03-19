package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskEndpoint {

    @Inject
    private ITaskRepository taskRepository;

    @WebMethod
    public void taskMerge(@WebParam(name = "task") Task task) {
        taskRepository.merge(task);
    }

    @WebMethod
    public Task taskGetById(@WebParam(name = "id") String id) {
        return taskRepository.findBy(id);
    }

    @WebMethod
    public List<Task> taskGetAll() {
        return taskRepository.findAll();
    }

    @WebMethod
    public void taskDelete(@WebParam(name = "id") String id) {
        taskRepository.remove(taskRepository.findBy(id));
    }
}
