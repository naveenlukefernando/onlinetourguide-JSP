package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UsersFetchDao {

    protected final String sql = "select * from users";
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
                u.setLevel(rs.getInt("level"));
                usersList.add(u);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return usersList;

    }

    public User fetchCustomer(int id) {
        String sql_fetch = "select * from users where users.id =?";
        User user = new User();

        try {
            PreparedStatement ps = connection.prepareStatement(sql_fetch);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                user.setId(rs.getString("id"));
                user.setName(rs.getString("firstname"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setLevel(rs.getInt("level"));


            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return user;
    }

}
