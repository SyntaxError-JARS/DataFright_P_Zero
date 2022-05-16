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
import java.io.IOException;

@WebServlet("/accounts")
public class AccountServlet extends HttpServlet {

    private final HouseHoldServices houseHoldServices = new HouseHoldServices();
    private final HouseHoldDao houseHoldDao = new HouseHoldDao();
    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HouseHoldAccount[] accounts = houseHoldServices.readHouseHold();

        String payload = mapper.writeValueAsString(accounts);

        resp.getWriter().write(payload);
    }
}
