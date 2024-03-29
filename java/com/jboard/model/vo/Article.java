package com.jboard.model.vo;

public class Article {
    private int id;
    private String title;
    private String body;
    private String regDate;
    private String nickname;

    public Article(int id, String title, String body, String regDate, String nickname) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.regDate = regDate;
        this.nickname = nickname;
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
