package com.revature.whatdadogdoin.services;

import com.revature.whatdadogdoin.daos.PostDao;
import com.revature.whatdadogdoin.models.PostModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostCreationTestSuite {

    PostDao tut;

    @BeforeEach
    public void testPrep(){tut = new PostDao();}

    @Test
    public void testCreateCommentPostOnAStory_returnString(){

        PostModel actualResult = tut.createCommentPost(3, "mattman", "this is just a test, test 1");

        System.out.println(actualResult);

    }

}
