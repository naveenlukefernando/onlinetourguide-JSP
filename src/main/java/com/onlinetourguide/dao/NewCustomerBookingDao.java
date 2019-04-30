package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewCustomerBookingDao {

    protected final String sql = "INSERT INTO newbooking VALUES (NULL, ?,?, ?,?)";
    Connection connection = DbConnect.get_Connection();

    public static void main(String[] args) {
        NewCustomerBookingDao newCustomerBookingDao = new NewCustomerBookingDao();
//        newCustomerBookingDao.addBooking(28, 2, "2018-04-21",true);

        newCustomerBookingDao.confirmBooking(10);

    }

    public void addBooking(int tourPacID, int cusID, String date,boolean booking_status) {
        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setInt(1, tourPacID);
            ps.setInt(2, cusID);
            ps.setString(3, date);
            ps.setBoolean(4, booking_status);
            System.out.println(ps.executeUpdate());


        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }


    public void confirmBooking(int requestId) {

        final String confirmSql = "INSERT INTO current_booking SELECT * FROM newbooking WHERE newbooking.id = ?";

        final String deleteSql = "DELETE FROM newbooking WHERE newbooking.id = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(confirmSql);
            ps.setInt(1, requestId);
            System.out.println("Insert Success . | "+ps.executeUpdate());

            PreparedStatement psDel = connection.prepareStatement(deleteSql);
            psDel.setInt(1, requestId);
            System.out.println("Delete success. | "+psDel.executeUpdate());

            System.out.println("Confirmed");



        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


}
