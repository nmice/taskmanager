package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.repository.ProjectRepository;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mergeProjectByRequest(req);
        resp.sendRedirect(req.getContextPath() + "/project-list");
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

        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            name = project.getName();
        }
        project.setName(name);

        String description = request.getParameter("description");
        if (description == null || description.isEmpty()) {
            description = project.getDescription();
        }
        project.setDescription(description);

        Date dateBegin;
        try {
            dateBegin = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateBegin"));
        } catch (Exception e) {
            dateBegin = project.getDateBegin();
        }
        project.setDateBegin(dateBegin);

        Date dateEnd;
        try {
            dateEnd = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateEnd"));
        } catch (Exception e) {
            dateEnd = project.getDateEnd();
        }
        project.setDateEnd(dateEnd);

        projectRepository.merge(project);
    }
}
