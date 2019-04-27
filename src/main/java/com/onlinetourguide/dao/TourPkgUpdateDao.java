package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.TourPackage;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TourPkgUpdateDao {

    public static void main(String[] args) {
        TourPkgUpdateDao tourPkgUpdateDao = new TourPkgUpdateDao();
        System.out.println(tourPkgUpdateDao.sql);
    }
    protected final String sql = "UPDATE tourpakages SET " +
            "tour_name = ? " +
            "location_from = ? " +
            "location_to = ? " +
            "date = ? " +
            "price = ? " +
            "desp1 = ? " +
            "desp2 = ? " +
            "imageURL_1 = ? " +
            "imageURL_2 = ? " +
            "WHERE tourpakages.id = ?";

    Connection connection = DbConnect.get_Connection();
    TourPackage t = new TourPackage();

    public void UpdatePackage(String tour_name, String location_from, String location_to, String date,
                              String price, String desp_1, String desp_2, InputStream image_URL_1, InputStream image_URL_2) {

        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setString(1, tour_name);
            ps.setString(2, location_from);
            ps.setString(3, location_to);
            ps.setString(4, date);
            ps.setString(5, price);
            ps.setString(6, desp_1);
            ps.setString(7, desp_2);



            if (image_URL_1 != null && image_URL_2 != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(8, image_URL_1);
                ps.setBlob(9, image_URL_2);
            }

            int count = ps.executeUpdate();

            if (count > 0) {
                System.out.println("Update successfully");
            } else {
                System.out.println("Update not successfull.");
            }



        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }




}
