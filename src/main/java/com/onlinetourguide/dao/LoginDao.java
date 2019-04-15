package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {


    Connection connection = DbConnect.get_Connection();

    String sql = "select * from admin where username=? AND password=?";

    public boolean check(String username, String password) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }


        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }

}
