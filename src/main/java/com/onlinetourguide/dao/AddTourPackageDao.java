package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTourPackageDao {


    protected final String sql = "INSERT INTO tourpakages VALUES (NULL,?,?,?,?,?,?,?,?,?)";
    Connection connection = DbConnect.get_Connection();


    public void addTourPackage(String tour_name, String location_from, String location_to, String date,
                               String price, String desp1, String desp2, InputStream imageURL_1, InputStream imageURL_2) {

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(this.sql);
            ps.setString(1, tour_name);
            ps.setString(2, location_from);
            ps.setString(3, location_to);
            ps.setString(4, date);
            ps.setString(5, price);
            ps.setString(6, desp1);
            ps.setString(7, desp2);

            if (imageURL_1 != null && imageURL_2 != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(8, imageURL_1);
                ps.setBlob(9, imageURL_2);
            }

            int count = ps.executeUpdate();

            if (count > 0) {
                System.out.println("Insert successfully");
            } else {
                System.out.println("Insert not successfull.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
