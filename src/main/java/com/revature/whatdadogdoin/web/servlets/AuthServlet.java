package com.revature.whatdadogdoin.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.services.HouseHoldServices;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    private final HouseHoldServices houseHoldServices = new HouseHoldServices();
    private final HouseHoldDao houseHoldDao = new HouseHoldDao();
    private final ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HouseHoldAccount reqAccount = mapper.readValue(req.getInputStream(), HouseHoldAccount.class);
        HouseHoldAccount authAccount = houseHoldServices.authenticateAccount(reqAccount.getHouseHoldUsername(), reqAccount.getPassWord());

    }

}
