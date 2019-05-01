package com.onlinetourguide.controller;

import com.onlinetourguide.dao.CurrentBookingDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCurrentBooking", urlPatterns = {"/DeleteCurrentBooking"})
public class DeleteCurrentBooking extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String t = request.getParameter("id");


        if (request.getParameter("w").equals("3")) {

            CurrentBookingDao dao = new CurrentBookingDao();
            dao.deleteBooking(Integer.parseInt(t));

            response.sendRedirect("manageCurrentBooking.jsp");
        }
    }
}
