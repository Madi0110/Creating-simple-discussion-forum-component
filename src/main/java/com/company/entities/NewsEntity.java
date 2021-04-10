package com.company.entities;

public class NewsEntity {
    int id;
    String title;
    String body;
    int authorId;

    public NewsEntity(String title, String body, int authorId) {
        this.title = title;
        this.body = body;
        this.authorId = authorId;
    }

    public NewsEntity(int id, String title, String body, int authorId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", authorId=" + authorId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
