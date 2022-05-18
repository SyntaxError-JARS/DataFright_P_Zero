package com.revature.whatdadogdoin.services;

import com.revature.whatdadogdoin.daos.StoryDao;
import com.revature.whatdadogdoin.models.StoryModel;
import com.revature.whatdadogdoin.util.web.dto.PassInStoryCreatePost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoryCreationTestSuite {

    StoryDao tut;

    @BeforeEach
    public void testPrep(){
        tut = new StoryDao();
    }


    @Test
    public void testCreateStoryPost_returnString() {

        StoryModel actualResult = tut.createStoryPost("test", "this is just a test");

        System.out.println(actualResult);
    }


}
