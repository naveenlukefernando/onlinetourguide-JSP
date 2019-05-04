package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserDao {


    protected final String sql = "UPDATE users SET email = ?,password = ?,firstname = ?,lastname = ?, phone = ?  WHERE users.id = ?";
    protected final String sql_update = "select * from customer WHERE customer.id = ?";
    Connection connection = DbConnect.get_Connection();


    public void UpdateUser(String id, String name, String lname, String email, String password, String phone) {

        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, lname);
            ps.setString(5, phone);
            ps.setString(6, id);


            ps.executeUpdate();
            System.out.println("update successfully.");

        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }


}
