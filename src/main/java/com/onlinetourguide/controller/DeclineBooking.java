package com.onlinetourguide.controller;

import com.onlinetourguide.dao.NewCustomerBookingDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeclineBooking", urlPatterns = {"/DeclineBooking"})
public class DeclineBooking extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String t = request.getParameter("id");


        if (request.getParameter("w").equals("3")) {

            NewCustomerBookingDao dao = new NewCustomerBookingDao();
            dao.declineRequest(Integer.parseInt(t));

            response.sendRedirect("manageNewBooking.jsp");
        }


    }
}
