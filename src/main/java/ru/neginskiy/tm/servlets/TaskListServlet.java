package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.TaskRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task-list")
public class TaskListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("projectId");
        List<Task> projectsTaskList = TaskRepository.getInstance().getByProjectId(projectId);
        req.setAttribute("tasks", projectsTaskList);
        req.setAttribute("projectId", projectId);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/task-list.jsp");
        requestDispatcher.forward(req, resp);
    }
}