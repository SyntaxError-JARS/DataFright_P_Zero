package com.revature.whatdadogdoin.util.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.exceptions.AuthenticationException;
import com.revature.whatdadogdoin.exceptions.InvalidRequestException;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.services.HouseHoldServices;
import com.revature.whatdadogdoin.util.web.dto.LoginCreds;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    private final HouseHoldServices houseHoldServices;
    private final HouseHoldDao houseHoldDao;
    private final ObjectMapper mapper;

    public AuthServlet(HouseHoldServices houseHoldServices, HouseHoldDao houseHoldDao, ObjectMapper mapper){
        this.houseHoldServices = houseHoldServices;
        this.mapper = mapper;
        this.houseHoldDao = houseHoldDao;
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            //HouseHoldAccount reqAccount = mapper.readValue(req.getInputStream(), HouseHoldAccount.class);

            LoginCreds loginCreds = mapper.readValue(req.getInputStream(),LoginCreds.class);

            HouseHoldAccount authAccount = houseHoldServices.authenticateAccount(loginCreds.getHouseHoldUsername(), loginCreds.getPassWord());

            //authAccount = houseHoldServices.authenticateAccount(reqAccount.getHouseHoldUsername(), reqAccount.getPassWord());

            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("authAccount", authAccount);

            resp.getWriter().write("You have successfully logged in!");
            resp.setStatus(200);
        } catch (AuthenticationException | InvalidRequestException e){
            resp.setStatus(403);
            resp.getWriter().write(e.getMessage());
        } catch (Exception e){
            resp.setStatus(413);
            resp.getWriter().write(e.getMessage());
        }
    }

}
