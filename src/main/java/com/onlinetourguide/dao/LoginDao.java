package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {


    private int userLevel;
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    Connection connection = DbConnect.get_Connection();

    protected final String sql = "select * from users where email=? AND password=?";

    public boolean check(String username, String password) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                setUserLevel(rs.getInt("level"));
                setId(rs.getInt("id"));
                return true;
            }


        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }




}
