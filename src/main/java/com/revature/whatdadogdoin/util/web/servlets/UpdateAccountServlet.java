package com.revature.whatdadogdoin.util.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.services.HouseHoldServices;
import com.revature.whatdadogdoin.util.web.dto.LoginCreds;
import com.revature.whatdadogdoin.util.web.dto.UpdatePassIn;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAccountServlet extends HttpServlet {

    private final HouseHoldServices houseHoldServices;
    private final HouseHoldDao houseHoldDao;
    private final ObjectMapper mapper;

    public UpdateAccountServlet(HouseHoldServices houseHoldServices, HouseHoldDao houseHoldDao, ObjectMapper mapper) {
        this.houseHoldServices = houseHoldServices;
        this.houseHoldDao = houseHoldDao;
        this.mapper = mapper;
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        //LoginCreds loginCreds = mapper.readValue(req.getInputStream(),LoginCreds.class);
        UpdatePassIn updatePassIn = mapper.readValue(req.getInputStream(),UpdatePassIn.class);
        //HouseHoldAccount updatedAccount = mapper.readValue(req.getInputStream(), HouseHoldAccount.class);
        HouseHoldAccount persistedAccountUpdate = houseHoldDao.returnUpdate(updatePassIn.getNewName(), updatePassIn.getOldName());

        String payload = mapper.writeValueAsString(persistedAccountUpdate);

        resp.getWriter().write("Persisted the update provided to household account as show below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }
}
