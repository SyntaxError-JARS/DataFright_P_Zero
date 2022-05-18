package com.revature.whatdadogdoin.models;

public class StoryModel {

    private Integer postID;
    private String houseHoldUsername;
    private Integer likeCount;
    private String content;

    public StoryModel(Integer postID, String houseHoldUsername, Integer likeCount, String content) {
        this.postID = postID;
        this.houseHoldUsername = houseHoldUsername;
        this.likeCount = likeCount;
        this.content = content;
    }

    public StoryModel() {

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

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "StoryModel{" +
                "postID=" + postID +
                ", houseHoldUsername='" + houseHoldUsername + '\'' +
                ", likeCount=" + likeCount +
                ", content='" + content + '\'' +
                '}';
    }
}
