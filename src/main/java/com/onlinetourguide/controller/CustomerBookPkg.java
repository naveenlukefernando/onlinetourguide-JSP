package com.onlinetourguide.controller;

import com.onlinetourguide.dao.NewCustomerBookingDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerBookPkg",urlPatterns = {"/CustomerBookPkg"})
public class CustomerBookPkg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int tourId = Integer.parseInt(request.getParameter("tourId"));
        int cusID = Integer.parseInt(request.getParameter("cusId"));
        String date = request.getParameter("pdate");
        int adults = Integer.parseInt(request.getParameter("adult"));
        int child = Integer.parseInt(request.getParameter("child"));


        NewCustomerBookingDao newCustomerBookingDao = new NewCustomerBookingDao();
        newCustomerBookingDao.addBooking(tourId,cusID,date,adults,child,false);

        response.sendRedirect("CustomerPendingBooking.jsp");


    }


}
