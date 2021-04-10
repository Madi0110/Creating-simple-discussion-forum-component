package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    private final static Connection conn = getConn();

    public static Connection getConnection() {
        return conn;
    }

    private static Connection getConn() {
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:my.db");

            Statement stmt;

            // Create tables schema
            stmt = c.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS users (\n" +
                    "    user_id INTEGER NOT NULL PRIMARY KEY,\n" +
                    "    user_login TEXT NOT NULL,\n" +
                    "    user_password TEXT NOT NULL,\n" +
                    "    user_fname TEXT,\n" +
                    "    user_lname TEXT\n" +
                    ");");

            stmt = c.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS news (\n" +
                    "    news_id INTEGER NOT NULL PRIMARY KEY,\n" +
                    "    news_title TEXT NOT NULL,\n" +
                    "    news_body TEXT NOT NULL,\n" +
                    "    news_author INTEGER,\n" +
                    "    FOREIGN KEY (news_author)\n" +
                    "        REFERENCES users (user_id)\n" +
                    "        ON UPDATE CASCADE\n" +
                    "        ON DELETE SET NULL\n" +
                    ");");

            stmt = c.createStatement();
            stmt.execute("CREATE UNIQUE INDEX IF NOT EXISTS idx_users_login ON users (user_login);");

            return c;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
