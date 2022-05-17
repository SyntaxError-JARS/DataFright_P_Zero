package com.revature.whatdadogdoin.util.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.util.web.dto.PassInDeleteUsername;
import com.revature.whatdadogdoin.util.web.dto.UpdatePassIn;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    private final HouseHoldDao houseHoldDao;
    private final ObjectMapper mapper;

    public DeleteServlet(HouseHoldDao houseHoldDao, ObjectMapper mapper) {
        this.houseHoldDao = houseHoldDao;
        this.mapper = mapper;
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PassInDeleteUsername pass = mapper.readValue(req.getInputStream(), PassInDeleteUsername.class);

        Boolean testTrue = houseHoldDao.delete(pass.getUserName());

        String payload = mapper.writeValueAsString(testTrue);

        resp.getWriter().write("Account was deleted, see true near bottom to verify \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }

}
