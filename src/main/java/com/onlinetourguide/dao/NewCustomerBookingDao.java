package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewCustomerBookingDao {

    protected final String sql = "INSERT INTO newbooking VALUES (NULL, ?,?, ? )";
    Connection connection = DbConnect.get_Connection();

    public static void main(String[] args) {
        NewCustomerBookingDao newCustomerBookingDao = new NewCustomerBookingDao();
        newCustomerBookingDao.AddBooking(24, 1, "2018-04-21");

    }

    public void AddBooking(int tourPacID, int cusID, String date) {
        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setInt(1, tourPacID);
            ps.setInt(2, cusID);
            ps.setString(3, date);
            System.out.println(ps.executeUpdate());


        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

}
