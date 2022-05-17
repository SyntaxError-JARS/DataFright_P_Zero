package com.revature.whatdadogdoin.util.web.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.services.HouseHoldServices;
import com.revature.whatdadogdoin.util.web.servlets.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        ObjectMapper mapper = new ObjectMapper();
        HouseHoldDao houseHoldDao = new HouseHoldDao();
        HouseHoldServices houseHoldServices = new HouseHoldServices();

        AuthServlet authServlet = new AuthServlet(houseHoldServices, houseHoldDao, mapper);
        AccountServlet accountServlet = new AccountServlet(houseHoldServices, houseHoldDao, mapper);
        TestServlet testServlet = new TestServlet();
        CreateServlet createServlet = new CreateServlet(houseHoldServices, houseHoldDao, mapper);
        UpdateAccountServlet updateAccountServlet = new UpdateAccountServlet(houseHoldServices, houseHoldDao, mapper);

        ServletContext context = sce.getServletContext();
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");
        context.addServlet("AccountServlet", accountServlet).addMapping("/accounts");
        context.addServlet("TestServlet", testServlet).addMapping("/test");
        context.addServlet("CreateServlet", createServlet).addMapping("/create");
        context.addServlet("UpdateAccountServlet", updateAccountServlet).addMapping("/update");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
