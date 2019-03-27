package ru.neginskiy.tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    IUserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /*@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model*/
    /*        model.addAttribute("name",name);*/

    @PostMapping("/login")
    public String authorization(
            @RequestParam("username") final String username,
            @RequestParam("name") final String name,
            @RequestParam("password") final String password,
            
            HttpServletResponse httpServletResponse,
            Model model
    ) {
        String username = username;
        String name = name;
        String password = password;

        try {
            final String passwordHash = passwordHashUtil.md5(password);
            final String token = userService.signIn(username, passwordHash);
            httpServletResponse.addCookie(new Cookie("token", token));
            return "redirect:/project-list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }





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
