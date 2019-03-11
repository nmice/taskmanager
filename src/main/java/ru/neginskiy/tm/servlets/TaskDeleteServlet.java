package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task-delete")
public class TaskDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskRepository taskRepository = TaskRepository.getInstance();
        if (req.getParameter("id") != null) {
            String id = req.getParameter("id");
            taskRepository.delete(id);
        }
        resp.sendRedirect(req.getContextPath() + "/task-list?projectId="+req.getParameter("projectId"));
    }
}