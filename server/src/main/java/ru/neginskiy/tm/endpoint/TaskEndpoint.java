package ru.neginskiy.tm.endpoint;

import ru.neginskiy.tm.api.ISessionService;
import ru.neginskiy.tm.api.ITaskService;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskEndpoint {

    private ITaskService taskService;
    private ISessionService sessionService;

    public TaskEndpoint(ITaskService taskService, ISessionService sessionService) {
        this.taskService = taskService;
        this.sessionService = sessionService;
    }

    @WebMethod
    public void taskMerge(@WebParam(name = "session") Session session,
                          @WebParam(name = "task") Task task) {
        taskService.merge(task);
    }

    @WebMethod
    public Task taskGetById(@WebParam(name = "session") Session session,
                            @WebParam(name = "id") String id) {
        return taskService.getById(id);
    }

    @WebMethod
    public List<Task> taskGetAllByUserId(@WebParam(name = "session") Session session,
                                         @WebParam(name = "userId") String userId) {
        return taskService.getAllByUserId(userId);
    }

    @WebMethod
    public Task taskDelete(@WebParam(name = "session") Session session,
                           @WebParam(name = "id") String id) {
        return taskService.delete(id);
    }
}
