package com.company.database;

import com.company.entities.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    Connection conn = DbConnection.getConnection();

    public void addUser(UserEntity user) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(user_login, user_password, user_fname, user_lname)\n" +
                    "    VALUES (?, ?, ?, ?);");
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFname());
            stmt.setString(4, user.getLname());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public UserEntity getUser(int id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE user_id = ? LIMIT 1;");

            stmt.setInt(1, id);

            ResultSet r = stmt.executeQuery();
            if (r.next()) {
                return new UserEntity(r.getInt(1), r.getString(2),
                        r.getString(3), r.getString(4),
                        r.getString(5));
            }
        }
        catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }

    public UserEntity getUserByLogin(String login) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE user_login = ? LIMIT 1;");

            stmt.setString(1, login);

            ResultSet r = stmt.executeQuery();
            if (r.next()) {
                return new UserEntity(r.getInt(1), r.getString(2),
                        r.getString(3), r.getString(4),
                        r.getString(5));
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

}
