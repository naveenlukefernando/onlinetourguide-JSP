package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersFetchDao {


    protected final String sql = "select * from customer";
    Connection connection = DbConnect.get_Connection();
    ArrayList<User> usersList = new ArrayList<>();


    public ArrayList<User> fetchUser() {


        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(this.sql);

            while (rs.next()) {

                User u = new User();

                u.setId(rs.getString("id"));
                u.setName(rs.getString("firstname"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setLastname(rs.getString("lastname"));
                u.setPassword(rs.getString("password"));

                usersList.add(u);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return usersList;

    }

}
