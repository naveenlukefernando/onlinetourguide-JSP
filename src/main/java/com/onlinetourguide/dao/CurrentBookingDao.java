package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.CurrentBooking;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrentBookingDao {


    Connection connection = DbConnect.get_Connection();
    ArrayList<CurrentBooking> currentBookingsList = new ArrayList<>();
    ArrayList<CurrentBooking> customerCurrentBKList = new ArrayList<>();



    public static void main(String[] args) {
        CurrentBookingDao currentBookingDao = new CurrentBookingDao();



        for (CurrentBooking t : currentBookingDao.fetchCustomerBooking(8) ){
            System.out.println(t.getBid()+"|"+t.getTourPkgName()+"|"+t.getPrice()+"|"+ t.isBook_status()+"|"+t.getImageURL_1());

        }


    }


    public int currentBookingCount() {
        final String sqlCount = "select count(id) as id from current_booking";
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

    public ArrayList<CurrentBooking> fetchCurrentBooking() {
        final String sqlBooking = "select b.id as booking_id , c.id as cust_id , c.firstname as customer_name , c.lastname as lastname ,b.adults ,b.children ,c.email as email , c.phone,t.id as TourPackageID , t.tour_name as TourPackage , t.price as price , b.datetime as booked_date , b.booking_status from current_booking b INNER JOIN users c ON c.id = b.customer_id INNER JOIN tourpakages t  ON t.id = b.package_id";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sqlBooking);

            while (rs.next()) {

                CurrentBooking currentBooking = new CurrentBooking();

                currentBooking.setBid(rs.getInt("booking_id"));
                currentBooking.setCustomer_id(rs.getInt("cust_id"));
                currentBooking.setFname(rs.getString("customer_name"));
                currentBooking.setLname(rs.getString("lastname"));
                currentBooking.setAdults(rs.getInt("adults"));
                currentBooking.setChildren(rs.getInt("children"));
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


    public ArrayList<CurrentBooking> fetchCustomerBooking(int id) {
        final String sqlBooking = "select b.id as booking_id ,c.id as cid,t.id as TourPackageID ,t.imageURL_1 as image1, t.tour_name as TourPackage ,b.adults ,b.children ,t.price as price , b.datetime as booked_date , b.booking_status from current_booking b INNER JOIN users c ON c.id = b.customer_id INNER JOIN tourpakages t  ON t.id = b.package_id where c.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlBooking);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CurrentBooking currentBooking = new CurrentBooking();


                Blob blob1 = rs.getBlob("image1");

                InputStream inputStream = blob1.getBinaryStream();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                currentBooking.setBid(rs.getInt("booking_id"));
                currentBooking.setCustomer_id(rs.getInt("cid"));
                currentBooking.setPackageId(rs.getInt("TourPackageID"));
                currentBooking.setTourPkgName(rs.getString("TourPackage"));
                currentBooking.setChildren(rs.getInt("children"));
                currentBooking.setAdults(rs.getInt("adults"));
                currentBooking.setPrice(rs.getString("price"));
                currentBooking.setBook_date(rs.getString("booked_date"));
                currentBooking.setBook_status(rs.getBoolean("booking_status"));
                currentBooking.setImageURL_1(base64Image);
                customerCurrentBKList.add(currentBooking);

            }

        } catch (SQLException | IOException ex) {
            System.out.println(ex);
        }

        return customerCurrentBKList;
    }





}
