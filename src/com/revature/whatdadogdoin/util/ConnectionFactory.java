package com.revature.whatdadogdoin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    private ConnectionFactory(){


    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance(){
        return connectionFactory;
    }

    public Connection getConnection(){

        Connection conn = null;

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=project_zero";
        String user = "postgres";
        String password = "password";

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}

