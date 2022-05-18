package com.revature.whatdadogdoin.util.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.whatdadogdoin.daos.PostDao;
import com.revature.whatdadogdoin.models.PostModel;
import com.revature.whatdadogdoin.util.web.dto.PassInCreateCommentPost;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {

    private final PostDao postDao;
    private final ObjectMapper mapper;

    public PostServlet(PostDao postDao, ObjectMapper mapper) {
        this.postDao = postDao;
        this.mapper = mapper;
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PassInCreateCommentPost pass = mapper.readValue(req.getInputStream(), PassInCreateCommentPost.class);

        PostModel commentAdded = postDao.createCommentPost(pass.getStoryID(), pass.getUsername(), pass.getComment());

        String payload = mapper.writeValueAsString(commentAdded);

        resp.getWriter().write("Persisted the update provided to the story, the comment was added \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }
}