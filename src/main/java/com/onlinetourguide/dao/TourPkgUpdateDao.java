package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TourPkgUpdateDao {

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


    protected final String sql_NoImage = "UPDATE tourpakages SET " +
            "tour_name = ? " +
            "location_from = ? " +
            "location_to = ? " +
            "date = ? " +
            "price = ? " +
            "desp1 = ? " +
            "desp2 = ? " +
            "WHERE tourpakages.id = ?";

    protected final String sql_ImageOne = "UPDATE tourpakages SET " +
            "tour_name = ? " +
            "location_from = ? " +
            "location_to = ? " +
            "date = ? " +
            "price = ? " +
            "desp1 = ? " +
            "desp2 = ? " +
            "imageURL_1 = ? " +
            "WHERE tourpakages.id = ?";


    protected final String sql_ImageTwo = "UPDATE tourpakages SET " +
            "tour_name = ? " +
            "location_from = ? " +
            "location_to = ? " +
            "date = ? " +
            "price = ? " +
            "desp1 = ? " +
            "desp2 = ? " +
            "imageURL_2 = ? " +
            "WHERE tourpakages.id = ?";


    Connection connection = DbConnect.get_Connection();

    public static void main(String[] args) {
        TourPkgUpdateDao tourPkgUpdateDao = new TourPkgUpdateDao();
        System.out.println(tourPkgUpdateDao.sql);
        System.out.println(tourPkgUpdateDao.sql_NoImage);
        System.out.println(tourPkgUpdateDao.sql_ImageOne);
        System.out.println(tourPkgUpdateDao.sql_ImageTwo);

    }




    //updating only image one
    public void UpdatePackageImageOne (String tour_name, String location_from, String location_to, String date,
                                   String price, String desp_1, String desp_2, InputStream image_URL_1) {

        try {

            PreparedStatement pst = connection.prepareStatement(this.sql_ImageOne);
            pst.setString(1, tour_name);
            pst.setString(2, location_from);
            pst.setString(3, location_to);
            pst.setString(4, date);
            pst.setString(5, price);
            pst.setString(6, desp_1);
            pst.setString(7, desp_2);


            if (image_URL_1 != null) {
                // fetches input stream of the upload file for the blob column
                pst.setBlob(8, image_URL_1);

            }

            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Update successfully");
            } else {
                System.out.println("Update not successfull.");
            }


        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }





    //updating without image
    public void UpdatePackageNoImage(String tour_name, String location_from, String location_to, String date,
                              String price, String desp_1, String desp_2) {
        try {

            PreparedStatement pst = connection.prepareStatement(this.sql_NoImage);
            pst.setString(1, tour_name);
            pst.setString(2, location_from);
            pst.setString(3, location_to);
            pst.setString(4, date);
            pst.setString(5, price);
            pst.setString(6, desp_1);
            pst.setString(7, desp_2);

            pst.executeUpdate();


        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    //Updating full package
    public void UpdatePackageImage(String tour_name, String location_from, String location_to, String date,
                                   String price, String desp_1, String desp_2, InputStream image_URL_1, InputStream image_URL_2) {

        try {

            PreparedStatement pst = connection.prepareStatement(this.sql);
            pst.setString(1, tour_name);
            pst.setString(2, location_from);
            pst.setString(3, location_to);
            pst.setString(4, date);
            pst.setString(5, price);
            pst.setString(6, desp_1);
            pst.setString(7, desp_2);


            if (image_URL_1 != null && image_URL_2 != null) {
                // fetches input stream of the upload file for the blob column
                pst.setBlob(8, image_URL_1);
                pst.setBlob(9, image_URL_2);
            }

            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Update successfully");
            } else {
                System.out.println("Update not successfull.");
            }


        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }



        // update details without  ImageTwo
    public void UpdatePackageImageTwo (String tour_name, String location_from, String location_to, String date,
                                   String price, String desp_1, String desp_2,InputStream image_URL_2) {

        try {

            PreparedStatement pst = connection.prepareStatement(this.sql_ImageTwo);
            pst.setString(1, tour_name);
            pst.setString(2, location_from);
            pst.setString(3, location_to);
            pst.setString(4, date);
            pst.setString(5, price);
            pst.setString(6, desp_1);
            pst.setString(7, desp_2);


            if (image_URL_2 != null) {
                // fetches input stream of the upload file for the blob column

                pst.setBlob(9, image_URL_2);
            }

            int count = pst.executeUpdate();

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
