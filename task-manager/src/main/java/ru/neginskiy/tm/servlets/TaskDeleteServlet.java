package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.service.TaskService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task-delete")
public class TaskDeleteServlet extends HttpServlet {

    @Inject
    private TaskService taskService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            String id = req.getParameter("id");
            taskService.deleteById(id);
        }
        resp.sendRedirect(req.getContextPath() + "/task-list?projectId="+req.getParameter("projectId"));
    }
}
