package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.TourPackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TourPkgFetchDao {


//    public static void main(String[] args) {
//        TourPkgFetchDao pkgFetchDao = new TourPkgFetchDao();
//
//
//
//
//
//
////        for (TourPackage t : pkgFetchDao.searchPackage("Ga",2) )
////        {
////            System.out.println(t.getId());
////            System.out.println(t.getTour_name());
////        }
//    }


    protected final String sql = "select * from tourpakages";
    protected final String random = "SELECT * FROM tourpakages ORDER BY RAND() LIMIT 4";
    protected final String selectTour = "select * from tourpakages where id = ?";

    Connection connection = DbConnect.get_Connection();
    ArrayList<TourPackage> pkgList = new ArrayList<>();
    ArrayList<TourPackage> searchList = new ArrayList<>();


    public ArrayList<TourPackage> fetchPackages() {


        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(this.sql);

            while (rs.next()) {

                TourPackage t = new TourPackage();

                Blob blob1 = rs.getBlob("imageURL_1");
                Blob blob2 = rs.getBlob("imageURL_2");

                InputStream inputStream = blob1.getBinaryStream();
                InputStream inputStream1 = blob2.getBinaryStream();
                
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                while ((bytesRead = inputStream1.read(buffer)) != -1) {
                    outputStream1.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                byte[] imageBytes1 = outputStream1.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                String base64Image2 = Base64.getEncoder().encodeToString(imageBytes1);


                inputStream.close();
                outputStream.close();


                t.setId(rs.getString("id"));
                t.setTour_name(rs.getString("tour_name"));
                t.setDate(rs.getString("date"));
                t.setDuration(rs.getInt("duration"));
                t.setLocation_from(rs.getString("location_from"));
                t.setLocation_to(rs.getString("location_to"));
                t.setPrice(rs.getString("price"));
                t.setHotel_type(rs.getString("hotel"));
                t.setTransport_type(rs.getString("transport_type"));
                t.setDesp1(rs.getString("desp1"));
                t.setDesp2(rs.getString("desp2"));
                t.setImageURL_1(base64Image);
                t.setImageURL_2(base64Image2);


                pkgList.add(t);

            }

        } catch (SQLException | IOException e) {
            System.out.println(" Exception " + e);
        }

        return pkgList;

    }


    public ArrayList<TourPackage> fetchRandomPackages() {


        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(this.random);

            while (rs.next()) {

                TourPackage t = new TourPackage();

                Blob blob1 = rs.getBlob("imageURL_1");
                Blob blob2 = rs.getBlob("imageURL_2");

                InputStream inputStream = blob1.getBinaryStream();
                InputStream inputStream1 = blob2.getBinaryStream();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                while ((bytesRead = inputStream1.read(buffer)) != -1) {
                    outputStream1.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                byte[] imageBytes1 = outputStream1.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                String base64Image2 = Base64.getEncoder().encodeToString(imageBytes1);


                inputStream.close();
                outputStream.close();


                t.setId(rs.getString("id"));
                t.setTour_name(rs.getString("tour_name"));
                t.setDate(rs.getString("date"));
                t.setDuration(rs.getInt("duration"));
                t.setLocation_from(rs.getString("location_from"));
                t.setLocation_to(rs.getString("location_to"));
                t.setPrice(rs.getString("price"));
                t.setHotel_type(rs.getString("hotel"));
                t.setTransport_type(rs.getString("transport_type"));
                t.setDesp1(rs.getString("desp1"));
                t.setDesp2(rs.getString("desp2"));
                t.setImageURL_1(base64Image);
                t.setImageURL_2(base64Image2);


                pkgList.add(t);

            }

        } catch (SQLException | IOException e) {
            System.out.println(" Exception " + e);
        }

        return pkgList;

    }


    public TourPackage selectedTour(int bid)
    {
        TourPackage t = new TourPackage();

        try {
            PreparedStatement ps = connection.prepareStatement(this.selectTour);
            ps.setInt(1,bid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {



                Blob blob1 = rs.getBlob("imageURL_1");
                Blob blob2 = rs.getBlob("imageURL_2");

                InputStream inputStream = blob1.getBinaryStream();
                InputStream inputStream1 = blob2.getBinaryStream();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                while ((bytesRead = inputStream1.read(buffer)) != -1) {
                    outputStream1.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                byte[] imageBytes1 = outputStream1.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                String base64Image2 = Base64.getEncoder().encodeToString(imageBytes1);


                inputStream.close();
                outputStream.close();


                t.setId(rs.getString("id"));
                t.setTour_name(rs.getString("tour_name"));
                t.setDate(rs.getString("date"));
                t.setDuration(rs.getInt("duration"));
                t.setLocation_from(rs.getString("location_from"));
                t.setLocation_to(rs.getString("location_to"));
                t.setPrice(rs.getString("price"));
                t.setHotel_type(rs.getString("hotel"));
                t.setTransport_type(rs.getString("transport_type"));
                t.setDesp1(rs.getString("desp1"));
                t.setDesp2(rs.getString("desp2"));
                t.setImageURL_1(base64Image);
                t.setImageURL_2(base64Image2);




            }

        } catch (SQLException | IOException e) {
            System.out.println(" Exception " + e);
        }

        return t;



    }

    public ArrayList<TourPackage> searchPackage(String city , int duration) {


        try {

            PreparedStatement ps = connection.prepareStatement("select * from tourpakages t where t.location_to like '%"+city+"%'  OR  t.duration like '%"+duration+"%'");

            ResultSet rs = ps.executeQuery();



            while (rs.next()) {

                TourPackage t = new TourPackage();

                Blob blob1 = rs.getBlob("imageURL_1");
                Blob blob2 = rs.getBlob("imageURL_2");

                InputStream inputStream = blob1.getBinaryStream();
                InputStream inputStream1 = blob2.getBinaryStream();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                while ((bytesRead = inputStream1.read(buffer)) != -1) {
                    outputStream1.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                byte[] imageBytes1 = outputStream1.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                String base64Image2 = Base64.getEncoder().encodeToString(imageBytes1);


                inputStream.close();
                outputStream.close();


                t.setId(rs.getString("id"));
                t.setTour_name(rs.getString("tour_name"));
                t.setDate(rs.getString("date"));
                t.setDuration(rs.getInt("duration"));
                t.setLocation_from(rs.getString("location_from"));
                t.setLocation_to(rs.getString("location_to"));
                t.setPrice(rs.getString("price"));
                t.setHotel_type(rs.getString("hotel"));
                t.setTransport_type(rs.getString("transport_type"));
                t.setDesp1(rs.getString("desp1"));
                t.setDesp2(rs.getString("desp2"));
                t.setImageURL_1(base64Image);
                t.setImageURL_2(base64Image2);


                searchList.add(t);

            }

        } catch (SQLException | IOException e) {
            System.out.println(" Exception " + e);
        }

        return searchList;

    }


}
