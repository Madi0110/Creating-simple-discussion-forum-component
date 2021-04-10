package com.company.servlets;

import com.company.database.UserDao;
import com.company.entities.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "loginServlet",
        urlPatterns = "/login"
)
public class LoginServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        UserEntity user = userDao.getUserByLogin(req.getParameter("login"));

        if (user != null && user.getPassword().equals(req.getParameter("password"))) {
            HttpSession session = req.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("login", user.getLogin());
            session.setAttribute("fname", user.getFname());
            session.setAttribute("lname", user.getLname());
        }
        else {
            System.out.println("Failed to login.");
        }

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
