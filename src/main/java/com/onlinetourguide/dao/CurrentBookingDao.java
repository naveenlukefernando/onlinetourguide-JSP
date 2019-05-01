package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.CurrentBooking;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrentBookingDao {


    Connection connection = DbConnect.get_Connection();
    ArrayList<CurrentBooking> currentBookingsList = new ArrayList<>();


    public static void main(String[] args) {
        CurrentBookingDao currentBookingDao = new CurrentBookingDao();

        for (CurrentBooking t : currentBookingDao.fetchCurrentBooking() ){
            System.out.println(t.getBid()+"|"+t.getCustomer_id()+"|"+t.getFname()+ "|"+ t.getLname()+ "|"+ t.isBook_status());

        }
    }


    public ArrayList<CurrentBooking> fetchCurrentBooking() {
        final String sqlBooking = "select b.id as booking_id , c.id as cust_id , c.firstname as customer_name , c.lastname as lastname , c.email as email , c.phone,t.id as TourPackageID , t.tour_name as TourPackage , t.price as price , b.datetime as booked_date , b.booking_status from current_booking b INNER JOIN customer c ON c.id = b.customer_id INNER JOIN tourpakages t  ON t.id = b.package_id";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sqlBooking);

            while (rs.next()) {

                CurrentBooking currentBooking = new CurrentBooking();

                currentBooking.setBid(rs.getInt("booking_id"));
                currentBooking.setCustomer_id(rs.getInt("cust_id"));
                currentBooking.setFname(rs.getString("customer_name"));
                currentBooking.setLname(rs.getString("lastname"));
                currentBooking.setEmail(rs.getString("email"));
                currentBooking.setPhone(rs.getString("phone"));
                currentBooking.setPackageId(rs.getInt("TourPackageID"));
                currentBooking.setTourPkgName(rs.getString("TourPackage"));
                currentBooking.setPrice(rs.getString("price"));
                currentBooking.setBook_date(rs.getString("booked_date"));
                currentBooking.setBook_status(rs.getBoolean("booking_status"));
                currentBookingsList.add(currentBooking);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return currentBookingsList;
    }



    public void deleteBooking(int requestId) {
        final String deleteSQL = "DELETE FROM current_booking WHERE current_booking.id = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(deleteSQL);
            ps.setInt(1, requestId);
            ps.executeUpdate();
            System.out.println("deleted ! ");


        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
