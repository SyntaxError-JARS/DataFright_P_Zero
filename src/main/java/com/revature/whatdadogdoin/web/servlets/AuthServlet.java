package com.revature.whatdadogdoin.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.excetpion.AuthenticationException;
import com.revature.whatdadogdoin.excetpion.InvalidRequestException;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.services.HouseHoldServices;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    private final HouseHoldServices houseHoldServices = new HouseHoldServices();
    private final HouseHoldDao houseHoldDao = new HouseHoldDao();
    private final ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            HouseHoldAccount reqAccount = mapper.readValue(req.getInputStream(), HouseHoldAccount.class);
            HouseHoldAccount authAccount = null;
            authAccount = houseHoldServices.authenticateAccount(reqAccount.getHouseHoldUsername(), reqAccount.getPassWord());

            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("authAccount", authAccount);

            resp.setStatus(69);
            resp.getWriter().write("You have successfully logged in!");
        } catch (AuthenticationException | InvalidRequestException e){
            resp.setStatus(403);
            resp.getWriter().write(e.getMessage());
        } catch (Exception e){
            resp.setStatus(420);
            resp.getWriter().write(e.getMessage());
        }
    }

}

//@WebServlet("/auth")
//public class AuthServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//        resp.getWriter().write("<h1>Test Authing Auth this Servlet is working as intended for What-Da-Dog-Doin'</h1>");
//
//    }
//
//}