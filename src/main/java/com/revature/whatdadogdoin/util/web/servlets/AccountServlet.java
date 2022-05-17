package com.revature.whatdadogdoin.util.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.services.HouseHoldServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.revature.whatdadogdoin.util.web.servlets.Authable.checkAuth;

public class AccountServlet extends HttpServlet implements Authable {

    private final HouseHoldServices houseHoldServices;
    private final HouseHoldDao houseHoldDao;
    private final ObjectMapper mapper;

    public AccountServlet(HouseHoldServices houseHoldServices, HouseHoldDao houseHoldDao, ObjectMapper mapper) {
        this.houseHoldServices = houseHoldServices;
        this.houseHoldDao = houseHoldDao;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(!checkAuth(req, resp)) return;

        HouseHoldAccount[] accounts = houseHoldServices.readHouseHold();

        String payload = mapper.writeValueAsString(accounts);

        resp.getWriter().write(payload);

    }


}
