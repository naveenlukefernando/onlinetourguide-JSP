package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersFetchDao {


    Connection connection = DbConnect.get_Connection();
    protected String sql = "select * from customer";

    ArrayList<User> usersList = new ArrayList<>();


    public ArrayList<User> fetchUser ()
    {


        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(this.sql);

            while(rs.next())
            {

                User u = new User();

                u.setId(rs.getString("id"));
                u.setName(rs.getString("name"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));

                usersList.add(u);

            }

        }

        catch (SQLException ex) {
            System.out.println(ex);
        }

        return usersList;

    }

}
