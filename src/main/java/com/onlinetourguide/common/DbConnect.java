package com.onlinetourguide.common;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbConnect {


    public static Connection get_Connection() {


        Connection connection = null;
        PreparedStatement ps = null;
        Resultset resultset = null;

        String host = "jdbc:mysql://localhost:3306/onlinetourguide";
        String username = "root";
        String password = "oop@123";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(host, username, password);
            System.out.println("Database Connected Successfully.");
        } catch (Exception e) {
            System.out.println(e);
        }


        return connection;

    }

}
