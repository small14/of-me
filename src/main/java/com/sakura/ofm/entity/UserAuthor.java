package com.sakura.ofm.entity;

public class UserAuthor {
    private String userAuthorId;

    private String userId;

    private String authorId;

    public String getUserAuthorId() {
        return userAuthorId;
    }

    public void setUserAuthorId(String userAuthorId) {
        this.userAuthorId = userAuthorId == null ? null : userAuthorId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }
}