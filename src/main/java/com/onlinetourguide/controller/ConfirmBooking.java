package com.onlinetourguide.controller;

import com.onlinetourguide.dao.NewCustomerBookingDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfirmBooking", urlPatterns = {"/ConfirmBooking"})
public class ConfirmBooking extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String t = request.getParameter("id");


        if (request.getParameter("confirm").equals("3")) {

            NewCustomerBookingDao dao = new NewCustomerBookingDao();
            dao.confirmBooking(Integer.parseInt(t));

            response.sendRedirect("manageNewBooking.jsp");
        }

    }
}
