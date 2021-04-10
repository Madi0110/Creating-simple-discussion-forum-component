package com.company.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(
        filterName = "authFilter",
        servletNames = "newsServlet"
)
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        if (req.getSession().getAttribute("id") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            System.out.println("Log in to add news.");
            req.getRequestDispatcher("home.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
