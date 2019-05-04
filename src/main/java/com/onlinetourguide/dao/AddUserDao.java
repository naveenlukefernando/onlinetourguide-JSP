package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddUserDao {

    public static void main(String[] args) {
        AddUserDao addUserDao = new AddUserDao();
        addUserDao.addUser("Amila","fernando","amila@gmail.com","123","0775645789",2);
    }

    protected final String sql = "insert into users values (NULL ,?,?,?,?,?,?)";
    Connection connection = DbConnect.get_Connection();

    public void addUser(String name, String lname, String email, String password, String phone, int level) {
        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, lname);
            ps.setString(5, phone);
            ps.setInt(6,level);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
