package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.BookingRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewCustomerBookingDao {

    protected final String sql = "INSERT INTO newbooking VALUES (NULL, ?,?, ?,?)";

    Connection connection = DbConnect.get_Connection();
    ArrayList<BookingRequest> bookingRequestsList = new ArrayList<>();

    public static void main(String[] args) {
        NewCustomerBookingDao newCustomerBookingDao = new NewCustomerBookingDao();
        //newCustomerBookingDao.addBooking(32, 2, "2018-04-21", true);
        //System.out.println(newCustomerBookingDao.bookingRequestCount());
        String k = "";

        System.out.println(k);

    }

    public void addBooking(int tourPacID, int cusID, String date, boolean booking_status) {
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
            ps.executeUpdate();

            PreparedStatement psDel = connection.prepareStatement(deleteSql);
            psDel.setInt(1, requestId);
            psDel.executeUpdate();

            System.out.println("Confirmed");


        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


    public void declineRequest(int requestId) {
        final String declineSql = "DELETE FROM newbooking WHERE newbooking.id = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(declineSql);
            ps.setInt(1, requestId);
            ps.executeUpdate();
            System.out.println("declined");


        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public ArrayList<BookingRequest> fetchBookingRequest() {
        final String sqlBooking = "select n.id as booking_id ,c.id as cust_id ,c.firstname as customer_name, c.lastname as lastname ,c.email as email,c.phone,t.id as TourPackageID ,t.tour_name as TourPackage, t.price as price ,n.datetime as booked_date from newbooking n INNER JOIN users c ON c.id = n.customer_id INNER JOIN tourpakages t  ON t.id = n.package_id";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sqlBooking);

            while (rs.next()) {

                BookingRequest b = new BookingRequest();

                b.setBid(rs.getInt("booking_id"));
                b.setCustomer_id(rs.getInt("cust_id"));
                b.setFname(rs.getString("customer_name"));
                b.setLname(rs.getString("lastname"));
                b.setEmail(rs.getString("email"));
                b.setPhone(rs.getString("phone"));
                b.setPackageId(rs.getInt("TourPackageID"));
                b.setTourPkgName(rs.getString("TourPackage"));
                b.setPrice(rs.getString("price"));
                b.setBook_date(rs.getString("booked_date"));

                bookingRequestsList.add(b);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return bookingRequestsList;
    }

    public int bookingRequestCount() {
        final String sqlCount = "select count(id) as id from newbooking";
        int count = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sqlCount);

            while (rs.next()) {


                count = rs.getInt("id");


            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return count;
    }


}
