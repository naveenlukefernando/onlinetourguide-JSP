package com.onlinetourguide.controller;

import com.onlinetourguide.dao.AddUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUser", urlPatterns = {"/AddUser"})
public class AddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");


        AddUserDao dao = new AddUserDao();

        dao.addStudent(name, phone, email);


        response.sendRedirect("manageUsers.jsp");


    }


}
