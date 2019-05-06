package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.BookingRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewCustomerBookingDao {

    protected final String sql = "INSERT INTO newbooking VALUES (NULL, ?,?, ?,?,?,?)";

    Connection connection = DbConnect.get_Connection();
    ArrayList<BookingRequest> bookingRequestsList = new ArrayList<>();
    ArrayList<BookingRequest> customerPendingBkList = new ArrayList<>();

    public static void main(String[] args) {
        NewCustomerBookingDao newCustomerBookingDao = new NewCustomerBookingDao();
        newCustomerBookingDao.addBooking(32, 11, "2018-04-21", 2,2,false);

       // newCustomerBookingDao.confirmBooking(52);


        //System.out.println(newCustomerBookingDao.bookingRequestCount());


    }

    public void addBooking(int tourPacID, int cusID, String date,int adults,int children, boolean booking_status) {
        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setInt(1, tourPacID);
            ps.setInt(2, cusID);
            ps.setString(3, date);
            ps.setInt(4,adults);
            ps.setInt(5,children);
            ps.setBoolean(6, booking_status);
            System.out.println(ps.executeUpdate());


        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }


    public void confirmBooking(int requestId) {

        final String confirmSql = "INSERT INTO current_booking SELECT * FROM newbooking WHERE newbooking.id = ?";

        final String deleteSql = "DELETE FROM newbooking WHERE newbooking.id = ?";

        final String markAsConfirmed = "UPDATE newbooking b SET b.booking_status=true where b.id= ?";

        try {

            PreparedStatement psUpdate = connection.prepareStatement(markAsConfirmed);
            psUpdate.setInt(1, requestId);
            psUpdate.executeUpdate();


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
        final String sqlBooking = "select n.id as booking_id ,c.id as cust_id ,c.firstname as customer_name, c.lastname as lastname,n.adults,n.children ,c.email as email,c.phone,t.id as TourPackageID ,t.tour_name as TourPackage, t.price as price ,n.datetime as booked_date from newbooking n INNER JOIN users c ON c.id = n.customer_id INNER JOIN tourpakages t  ON t.id = n.package_id";

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
                b.setAdult(rs.getInt("adults"));
                b.setChildren(rs.getInt("children"));
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


    public ArrayList<BookingRequest> fetchCustomerPendingBooking(int id) {
        final String sqlBooking = "select n.id as booking_id ,c.id as cid ,t.id as TourPackageID,t.imageURL_1 as image1 ,t.tour_name as TourPackage,n.adults,n.children, t.price as price ,n.datetime as booked_date, n.booking_status  from newbooking n INNER JOIN users c ON c.id = n.customer_id INNER JOIN tourpakages t  ON t.id = n.package_id where c.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlBooking);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                BookingRequest pendingBooking = new BookingRequest();


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

                pendingBooking.setBid(rs.getInt("booking_id"));
                pendingBooking.setCustomer_id(rs.getInt("cid"));
                pendingBooking.setPackageId(rs.getInt("TourPackageID"));
                pendingBooking.setTourPkgName(rs.getString("TourPackage"));
                pendingBooking.setPrice(rs.getString("price"));
                pendingBooking.setAdult(rs.getInt("adults"));
                pendingBooking.setChildren(rs.getInt("children"));
                pendingBooking.setBook_date(rs.getString("booked_date"));
                pendingBooking.setBook_status(rs.getBoolean("booking_status"));
                pendingBooking.setImageUrl(base64Image);
                customerPendingBkList.add(pendingBooking);

            }

        } catch (SQLException | IOException ex) {
            System.out.println(ex);
        }

        return customerPendingBkList;
    }


}
