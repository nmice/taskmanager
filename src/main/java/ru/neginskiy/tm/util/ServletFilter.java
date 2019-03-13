package ru.neginskiy.tm.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

//@WebFilter("/project-list")
public class ServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        if (session.getAttribute("userId") == null) {
            HttpServletResponse resp = (HttpServletResponse)response;
            resp.sendRedirect("");
//            req.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        String servletPath = req.getServletPath();
        System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath + ", URL =" + req.getRequestURL());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy");
    }
}

