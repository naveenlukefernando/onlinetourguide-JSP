package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserDao {


    protected final String sql = "DELETE FROM customer WHERE customer.id = ?";
    Connection connection = DbConnect.get_Connection();

    public void deleteUser(String id) {

        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }


    }

}
