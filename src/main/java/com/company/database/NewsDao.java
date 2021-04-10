package com.company.database;

import com.company.entities.NewsEntity;
import com.company.entities.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    Connection conn = DbConnection.getConnection();

    public void addNews(NewsEntity news) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO news(news_title, news_body, news_author)\n" +
                    "    VALUES (?, ?, ?);");
            stmt.setString(1, news.getTitle());
            stmt.setString(2, news.getBody());
            stmt.setInt(3, news.getAuthorId());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public NewsEntity getNews(int id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM news WHERE news_id = ? LIMIT 1;");

            stmt.setInt(1, id);

            ResultSet r = stmt.executeQuery();
            if (r.next()) {
                return new NewsEntity(r.getInt(1),
                        r.getString(2),
                        r.getString(3),
                        r.getInt(4));
            }
        }
        catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<NewsEntity> getAllNews() {
        ArrayList<NewsEntity> newsList = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM news;");

            ResultSet r = stmt.executeQuery();
            while (r.next()) {
                newsList.add(new NewsEntity(r.getInt(1),
                        r.getString(2),
                        r.getString(3),
                        r.getInt(4)));
            }
        }
        catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return newsList;
    }
}
