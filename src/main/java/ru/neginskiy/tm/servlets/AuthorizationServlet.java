package ru.neginskiy.tm.servlets;

import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = UserRepository.getInstance();

        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if (username == null) {
            //is a create user page:
            if(userRepository.isRegistredLogin(name)){
                req.setAttribute("loginMessage", "This login is registred now!");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
                requestDispatcher.forward(req, resp);
            }
            User user = new User();
            user.setLogin(name);
            user.setPassword(password);
            userRepository.merge(user);
            req.setAttribute("loginMessage", "Please login");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            //is a login page:
            User user = userRepository.findUser(username, password);
            if (user == null) {
                req.setAttribute("loginMessage", "User not found!");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("userId",user.getId());
                resp.sendRedirect(req.getContextPath() + "/project-list");
            }
        }
    }
}
