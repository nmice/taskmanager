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

    @WebMethod
    public void taskMerge(@WebParam(name = "task") Task task) {
        taskService.merge(task);
    }

    @WebMethod
    public Task taskGetById(@WebParam(name = "id") String id) {
        return taskService.getById(id);
    }

    @WebMethod
    public List<Task> taskGetAllByUserId(@WebParam(name = "userId") String userId) {
        return taskService.getAllByUserId(userId);
    }

    @WebMethod
    public Task taskDelete(@WebParam(name = "id") String id) {
        return taskService.delete(id);
    }
}
