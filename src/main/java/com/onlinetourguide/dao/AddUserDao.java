package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddUserDao {

    Connection connection = DbConnect.get_Connection();

    User user = new User();

    protected String sql = "insert into customer values (NULL ,?,?,?)";


    public void addStudent(String sname, String phone , String email)
    {
        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setString(1,sname);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.executeUpdate();

        }
        catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
