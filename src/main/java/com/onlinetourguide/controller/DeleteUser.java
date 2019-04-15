package com.onlinetourguide.controller;

import com.onlinetourguide.dao.DeleteUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUser", urlPatterns = {"/DeleteUser"})
public class DeleteUser extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String t = request.getParameter("id");


        if (request.getParameter("action").equals("2") == true)
        {
            DeleteUserDao dao = new DeleteUserDao();
            dao.deleteUser(t);
            response.sendRedirect("manageUsers.jsp");
        }


    }

}
