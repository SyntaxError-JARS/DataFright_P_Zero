package com.revature.whatdadogdoin.util.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.services.HouseHoldServices;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateServlet extends HttpServlet {

    private final HouseHoldServices houseHoldServices;
    private final HouseHoldDao houseHoldDao;
    private final ObjectMapper mapper;

    public CreateServlet(HouseHoldServices houseHoldServices, HouseHoldDao houseHoldDao, ObjectMapper mapper) {
        this.houseHoldServices = houseHoldServices;
        this.houseHoldDao = houseHoldDao;
        this.mapper = mapper;
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        HouseHoldAccount newAccount = mapper.readValue(req.getInputStream(), HouseHoldAccount.class);
        HouseHoldAccount persistedAccount = houseHoldServices.create(newAccount);

        String payload = mapper.writeValueAsString(persistedAccount);

        resp.getWriter().write("Persisted the provided pokemon as show below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }

}
