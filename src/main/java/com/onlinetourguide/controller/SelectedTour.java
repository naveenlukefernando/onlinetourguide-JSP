package com.onlinetourguide.controller;

import com.onlinetourguide.dao.TourPkgFetchDao;
import com.onlinetourguide.model.TourPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SelectedTour", urlPatterns = {"/SelectedTour"})
public class SelectedTour extends HttpServlet {

    private static TourPackage tourPackage;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("bid"));

        tourPackage = new TourPkgFetchDao().selectedTour(id);

        HttpSession session = request.getSession();
        session.setAttribute("tour_pkg",tourPackage);
        response.sendRedirect("tour.jsp");




    }
}
