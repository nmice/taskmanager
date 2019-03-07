package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.repository.ProjectRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project-delete")
public class ProjectDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectRepository projectRepository = ProjectRepository.getInstance();
        if (req.getParameter("id") != null) {
            String id = req.getParameter("id");
            projectRepository.delete(id);
        }
        resp.sendRedirect(req.getContextPath() + "/project-list");
    }
    /*TODO DTO in DeltaSpike branch*/
}
