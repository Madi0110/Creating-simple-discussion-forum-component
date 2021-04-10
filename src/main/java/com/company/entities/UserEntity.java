package com.company.entities;

public class UserEntity {
    int id;
    String login;
    String password;
    String fname;
    String lname;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
        this.fname = "";
        this.lname = "";
    }

    public UserEntity(String login, String password, String fname, String lname) {
        this.id = -1;
        this.login = login;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }

    public UserEntity(int id, String login, String password, String fname, String lname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
