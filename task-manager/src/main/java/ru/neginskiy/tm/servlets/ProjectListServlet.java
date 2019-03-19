package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.service.ProjectService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project-list")
public class ProjectListServlet extends HttpServlet {

    @Inject
    private ProjectService projectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("projects", projectService.getAll());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/project-list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
