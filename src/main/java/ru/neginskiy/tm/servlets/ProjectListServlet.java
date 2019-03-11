package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.repository.ProjectRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/project-list")
public class ProjectListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectRepository projectRepository = ProjectRepository.getInstance();
        req.setAttribute("projects", projectRepository.getAll());
/*        HttpSession session = req.getSession();
       String userId = session.getAttribute("userId").toString();*/
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/project-list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
