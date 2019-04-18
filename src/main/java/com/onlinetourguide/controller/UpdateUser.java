package com.onlinetourguide.controller;

import com.onlinetourguide.dao.UpdateUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUser", urlPatterns = {"/UpdateUser"})
public class UpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("firstname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        UpdateUserDao updateUserDao = new UpdateUserDao();

        updateUserDao.UpdateUser(id, name, email, phone);

        response.sendRedirect("manageUsers.jsp");


    }


}