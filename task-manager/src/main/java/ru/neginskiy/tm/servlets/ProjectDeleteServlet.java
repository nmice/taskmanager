package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.service.ProjectService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/project-delete")
public class ProjectDeleteServlet extends HttpServlet {

    @Inject
    private ProjectService projectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            String id = req.getParameter("id");
            projectService.deleteById(id);
        }
        resp.sendRedirect(req.getContextPath() + "/project-list");
    }
}
