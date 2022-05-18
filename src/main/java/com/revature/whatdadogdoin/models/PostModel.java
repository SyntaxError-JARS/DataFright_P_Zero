package com.revature.whatdadogdoin.models;

public class PostModel {

    private Integer commentID;
    private Integer postID;
    private String houseHoldUsername;
    private String comment;

    public PostModel(Integer commentID, Integer postID, String houseHoldUsername, String comment) {
        this.commentID = commentID;
        this.postID = postID;
        this.houseHoldUsername = houseHoldUsername;
        this.comment = comment;
    }

    public PostModel() {

    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getHouseHoldUsername() {
        return houseHoldUsername;
    }

    public void setHouseHoldUsername(String houseHoldUsername) {
        this.houseHoldUsername = houseHoldUsername;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "commentID=" + commentID +
                ", postID=" + postID +
                ", houseHoldUsername='" + houseHoldUsername + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
