package ru.neginskiy.tm.controller;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.service.ProjectService;
import ru.neginskiy.tm.service.TaskService;
import ru.neginskiy.tm.service.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

    @Inject
    private TaskService taskService;
    @Inject
    private ProjectService projectService;
    @Inject
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User demoUser = new User();
        demoUser.setId("UID");
        demoUser.setLogin("test");
        demoUser.setPassword("test");
        userService.merge(demoUser);

        Project demoProject = new Project();
        demoProject.setId("PID");
        demoProject.setName("DEMO PROJECT");
        demoProject.setDescription("DESCRIPTION");
        demoProject.setDateBegin(new Date());
        demoProject.setDateEnd(new Date(System.currentTimeMillis() + 1_000_000_000));
        projectService.merge(demoProject);

        Task demoTask = new Task();
        demoTask.setId("TID");
        demoTask.setName("DEMO TASK");
        demoTask.setDescription("DESCRIPTION");
        demoTask.setDateBegin(new Date());
        demoTask.setDateEnd(new Date(System.currentTimeMillis() + 1_000_000_000));
        demoTask.setProject(demoProject);
        taskService.merge(demoTask);

        HttpSession activeSession = req.getSession();
        String message;
        if (activeSession.isNew()) {
            message = "Welcome to TASKMANAGER!";
        } else {
            message = "Glad to see You again!";
        }
        req.setAttribute("msg", message);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
        requestDispatcher.forward(req, resp);
    }
}
