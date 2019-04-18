package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.TourPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TourPkgFetchDao {

    protected String sql = "select * from tourpakages";
    Connection connection = DbConnect.get_Connection();
    ArrayList<TourPackage> usersList = new ArrayList<>();


    public ArrayList<TourPackage> fetchPackages() {


        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(this.sql);

            while (rs.next()) {

                TourPackage t = new TourPackage();

                t.setId(rs.getString("id"));
                t.setTour_name(rs.getString("tour_name"));
                t.setDate(rs.getString("date"));
                t.setLocation_from(rs.getString("location_from"));
                t.setLocation_to(rs.getString("location_to"));
                t.setPrice(rs.getString("price"));


                usersList.add(t);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return usersList;

    }

}