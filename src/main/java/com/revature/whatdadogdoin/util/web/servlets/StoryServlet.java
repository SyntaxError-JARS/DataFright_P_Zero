package com.revature.whatdadogdoin.util.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.daos.StoryDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.models.StoryModel;
import com.revature.whatdadogdoin.util.web.dto.PassInStoryCreatePost;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StoryServlet extends HttpServlet {

    private final StoryDao storyDao;
    private final ObjectMapper mapper;

    public StoryServlet(StoryDao storyDao, ObjectMapper mapper) {
        this.storyDao = storyDao;
        this.mapper = mapper;
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            PassInStoryCreatePost pass = mapper.readValue(req.getInputStream(), PassInStoryCreatePost.class);

            StoryModel addedStory = storyDao.createStoryPost(pass.getUsername(), pass.getContent());

            String payload = mapper.writeValueAsString(addedStory);

            resp.getWriter().write("Added the story as seen down below \n");
            resp.getWriter().write(payload);
            resp.setStatus(201);
        } catch (InvalidDefinitionException e){
            resp.setStatus(403);
            resp.getWriter().write(e.getMessage());
        }


    }

}
