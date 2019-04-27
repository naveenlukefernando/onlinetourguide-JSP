package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserDao {


    protected final String sql = "UPDATE customer SET name = ?, email = ?, phone = ?  WHERE customer.id = ?";
    protected final String sql_update = "select * from customer WHERE customer.id = ?";
    Connection connection = DbConnect.get_Connection();
    User u = new User();

    public void UpdateUser(String id, String name, String email, String phone) {

        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, id);
            ps.executeUpdate();
            System.out.println("update successfully.");

        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }


}
