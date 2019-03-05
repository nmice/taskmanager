package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.repository.ProjectRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/project-merge")
public class ProjectMergeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectRepository projectRepository = ProjectRepository.getInstance();
        mergeProjectByRequest(req);
        req.setAttribute("projects", projectRepository.getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/project-list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void mergeProjectByRequest(HttpServletRequest request) {
        ProjectRepository projectRepository = ProjectRepository.getInstance();
        Project project;
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            project = new Project();
        } else {
            project = projectRepository.getById(id);
        }
        String name;
        try {
            name = request.getParameter("name");
        } catch (Exception e) {
            name = project.getName();
        }
        String description;
        try {
            description = request.getParameter("description");
        } catch (Exception e) {
            description = project.getDescription();
        }
        Date dateBegin;
        try {
            dateBegin = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateBegin"));
        } catch (Exception e) {
            dateBegin = project.getDateBegin();
        }
        Date dateEnd;
        try {
            dateEnd = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateBegin"));
        } catch (Exception e) {
            dateEnd = project.getDateEnd();
        }
        project.setName(name);
        project.setDescription(description);
        project.setDateBegin(dateBegin);
        project.setDateEnd(dateEnd);
        projectRepository.merge(project);
    }
}
