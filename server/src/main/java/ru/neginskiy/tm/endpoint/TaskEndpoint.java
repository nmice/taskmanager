package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.service.TaskService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskEndpoint {

    private TaskService taskService;

    public TaskEndpoint(TaskService taskService) {
        this.taskService = taskService;
    }
    //todo rename methods and generate code for client"

    @WebMethod
    public void merge(@WebParam(name = "task") Task task) {
        taskService.merge(task);
    }

    @WebMethod
    public Task getById(@WebParam(name = "id") String id) {
        return taskService.getById(id);
    }

    @WebMethod
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @WebMethod
    public Task delete(@WebParam(name = "id") String id) {
        return taskService.delete(id);
    }
}
