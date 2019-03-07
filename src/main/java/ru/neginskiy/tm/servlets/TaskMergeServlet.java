package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/task-merge")
public class TaskMergeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mergeTaskByRequest(req);
        resp.sendRedirect(req.getContextPath() + "/task-list");
    }

    private void mergeTaskByRequest(HttpServletRequest request) {
        TaskRepository taskRepository = TaskRepository.getInstance();
        Task task;

        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            task = new Task();
        } else {
            task = taskRepository.getById(id);
        }

        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            name = task.getName();
        }
        task.setName(name);

        String description = request.getParameter("description");
        if (description == null || description.isEmpty()) {
            description = task.getDescription();
        }
        task.setDescription(description);

        Date dateBegin;
        try {
            dateBegin = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateBegin"));
        } catch (Exception e) {
            dateBegin = task.getDateBegin();
        }
        task.setDateBegin(dateBegin);

        Date dateEnd;
        try {
            dateEnd = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateEnd"));
        } catch (Exception e) {
            dateEnd = task.getDateEnd();
        }
        task.setDateEnd(dateEnd);

        String projectId = request.getParameter("projectId");
        if (projectId == null || projectId.isEmpty()) {
            projectId = task.getProjectId();
        }
        task.setProjectId(projectId);

        taskRepository.merge(task);
    }
}
