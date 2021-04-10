package com.company.servlets;

import com.company.database.NewsDao;
import com.company.entities.NewsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "newsServlet",
        urlPatterns = "/add-news"
)
public class NewsServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add-news.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsDao newsDao = new NewsDao();

        newsDao.addNews(new NewsEntity(
                req.getParameter("title"),
                req.getParameter("body"),
                (int)req.getSession().getAttribute("id")
        ));

        req.getRequestDispatcher("add-news.jsp").forward(req, resp);
    }
}
