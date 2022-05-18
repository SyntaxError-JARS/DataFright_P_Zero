package com.revature.whatdadogdoin.util.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassInStoryCreatePost {

    private String username;
    private String content;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
