package com.company.servlets;

import com.company.database.DbConnection;
import com.company.database.NewsDao;
import com.company.entities.NewsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "homeServlet",
        urlPatterns = "/"
)
public class HomeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = DbConnection.getConnection();

        NewsDao newsDao = new NewsDao();

        ArrayList<NewsEntity> newsList = newsDao.getAllNews();

        req.setAttribute("newsList", newsList);

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
