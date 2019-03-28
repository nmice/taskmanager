package ru.neginskiy.tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.entity.User;

import javax.servlet.http.*;

@Controller
public class LoginController {

    @Autowired
    IUserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String authorization(
            @RequestParam("username") final String username,
            @RequestParam("name") final String name,
            @RequestParam("password") final String password,
            HttpServletResponse httpServletResponse,
            Model model) {
        if (username == null) {
            //is a create user page:
            if (userService.isRegistredLogin(name)) {
                model.addAttribute("loginMessage", "This login is registred now!");
                return "login";
            }
            User user = new User();
            user.setLogin(name);
            user.setPassword(password);
            userService.merge(user);
            model.addAttribute("loginMessage", "Please login");
            return "login";
        } else {
            //is a login page:
            User user = userService.findUser(username, password);
            if (user == null) {
                model.addAttribute("loginMessage", "User not found!");
                return "login";
            } else {
                httpServletResponse.addCookie(new Cookie("userId", user.getId()));
                return "redirect:/project-list";
            }
        }
    }
}
