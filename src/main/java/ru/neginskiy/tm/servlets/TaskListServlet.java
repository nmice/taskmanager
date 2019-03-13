package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.repository.TaskRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task-list")
public class TaskListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("projectId");
        req.setAttribute("projectId", projectId);

        TaskRepository taskRepository = TaskRepository.getInstance();
        req.setAttribute("tasks", taskRepository.getByProjectId(projectId));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/task-list.jsp");
        requestDispatcher.forward(req, resp);
    }
}