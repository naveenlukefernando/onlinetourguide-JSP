package com.onlinetourguide.dao;

import com.onlinetourguide.common.DbConnect;
import com.onlinetourguide.model.User;

import java.sql.*;

public class UpdateUserDao {

//    public static void main(String[] args) {
//
//        UpdateUserDao dao = new UpdateUserDao();
//
//        dao.UpdateUser("103","Luke Fdo","jjnlfernando@gmail.com","0312227683");
//
//        User user = dao.selectedUser("103");
//        System.out.println(user.getName());
//        System.out.println(user.getPhone());
//        System.out.println(user.getEmail());
//    }


    protected String sql = "UPDATE customer SET name = ?, email = ?, phone = ?  WHERE customer.id = ?";
    protected String sql_update = "select * from customer WHERE customer.id = ?";
    Connection connection = DbConnect.get_Connection();
    User u = new User();

    public void UpdateUser(String id, String name, String email, String phone) {

        try {

            PreparedStatement ps = connection.prepareStatement(this.sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, id);
            ps.executeUpdate();
            System.out.println("update successfully.");

        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }


    public User selectedUser(String id) {

        try {
            PreparedStatement pst = connection.prepareStatement(this.sql_update);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                u.setId(rs.getString("id"));
                u.setName(rs.getString("name"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
            }


        } catch (SQLException sq) {
            System.out.println(sq);
        }

       return u;
    }


}
