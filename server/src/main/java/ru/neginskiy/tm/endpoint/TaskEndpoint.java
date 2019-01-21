package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.service.TaskService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskEndpoint {

    private TaskService taskService;

    public TaskEndpoint(TaskService taskService) {
        this.taskService = taskService;
    }

    @WebMethod
    public void merge(Task task) {
        taskService.merge(task);
    }

    @WebMethod
    public Task getById(String id) {
        return taskService.getById(id);
    }

    @WebMethod
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @WebMethod
    public Task delete(String id) {
        return taskService.delete(id);
    }

    //Todo methods - return something
}
