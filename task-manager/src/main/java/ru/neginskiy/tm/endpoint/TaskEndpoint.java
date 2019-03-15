package ru.neginskiy.tm.endpoint;



import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskEndpoint {

    @Inject
    private TaskRepository taskRepository;

    @WebMethod
    public void taskMerge(@WebParam(name = "task") Task task) {
        taskRepository.merge(task);
    }

    @WebMethod
    public Task taskGetById(@WebParam(name = "id") String id) {
        return taskRepository.getById(id);
    }

    @WebMethod
    public List<Task> taskGetAll() {
        return taskRepository.getAll();
    }

    @WebMethod
    public Task taskDelete(@WebParam(name = "id") String id) {
        return taskRepository.delete(id);
    }
}
