package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddUserDao {


    protected final String sql = "insert into customer values (NULL ,?,?,?,?,?)";
    Connection connection = DbConnect.get_Connection();

    public void addStudent(String name, String lname, String email, String password, String phone) {
        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, lname);
            ps.setString(5, phone);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
