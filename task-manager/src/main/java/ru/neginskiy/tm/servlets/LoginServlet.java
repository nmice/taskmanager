package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.service.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;

@Transactional
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if (username == null) {
            //is a create user page:
            if (userService.isRegistredLogin(name)) {
                req.setAttribute("loginMessage", "This login is registred now!");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
                requestDispatcher.forward(req, resp);
            }
            User user = new User();
            user.setLogin(name);
            user.setPassword(password);
            userService.merge(user);
            req.setAttribute("loginMessage", "Please login");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            //is a login page:
            User user = userService.findUser(username, password);
            if (user == null) {
                req.setAttribute("loginMessage", "User not found!");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("userId", user.getId());
                resp.sendRedirect(req.getContextPath() + "/project-list");
            }
        }
    }
}
