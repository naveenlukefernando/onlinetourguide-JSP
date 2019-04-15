package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserDao {


    Connection connection = DbConnect.get_Connection();
    protected String sql = "UPDATE customer SET name = ?, email = ?, phone = ?  WHERE customer.id = ?";


    public void UpdateUser (String id,String name,String email, String phone)
    {

        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,phone);
            ps.setString(4,id);
            ps.executeUpdate();

        }
        catch (SQLException ex) {
            System.out.println(ex);
        }



    }


}
