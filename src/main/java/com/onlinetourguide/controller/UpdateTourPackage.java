package com.onlinetourguide.controller;

import com.onlinetourguide.dao.TourPkgUpdateDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "UpdateTourPackage", urlPatterns = {"/UpdateTourPackage"})
@MultipartConfig
public class UpdateTourPackage extends HttpServlet {

    private InputStream imageUrl_1;
    private InputStream imageUrl_2;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String tour_name = request.getParameter("tour_name");
        String location_from = request.getParameter("from");
        String location_to = request.getParameter("to");
        String date = request.getParameter("date");
        String price = request.getParameter("price");
        String desp1 = request.getParameter("desp1");
        String desp2 = request.getParameter("desp2");
        String hotel = request.getParameter("hotel_type");
        String transport = request.getParameter("transport_type");

        Part filePart = request.getPart("file");
        Part filePart2 = request.getPart("file1");

        TourPkgUpdateDao pkgUpdateDao = new TourPkgUpdateDao();


        if (!filePart.getSubmittedFileName().isEmpty()) {
            imageUrl_1 = filePart.getInputStream();
            pkgUpdateDao.updatePackageImageOne(id, tour_name, location_from, location_to, date, price, desp1, desp2, imageUrl_1,hotel,transport);
            System.out.println("Image 1 Updated  " + filePart.getName());
            response.sendRedirect("manageTourPackages.jsp");

        } else if (!filePart2.getSubmittedFileName().isEmpty()) {
            imageUrl_2 = filePart2.getInputStream();
            pkgUpdateDao.updatePackageImageTwo(id, tour_name, location_from, location_to, date, price, desp1, desp2, imageUrl_2,hotel,transport);
            System.out.println("Image 2 Updated  " + filePart2.getName());
            response.sendRedirect("manageTourPackages.jsp");

        } else if (!filePart.getSubmittedFileName().isEmpty() && !filePart2.getSubmittedFileName().isEmpty()) {
            imageUrl_1 = filePart.getInputStream();
            imageUrl_2 = filePart2.getInputStream();
            pkgUpdateDao.updatePackageImageAll(id, tour_name, location_from, location_to, date, price, desp1, desp2, imageUrl_1, imageUrl_2,hotel,transport);
            System.out.println("All updated");
            response.sendRedirect("manageTourPackages.jsp");

        } else {
            pkgUpdateDao.updatePackageNoImage(id, tour_name, location_from, location_to, date, price, desp1, desp2,hotel,transport);
            System.out.println("No Image Update");
            response.sendRedirect("manageTourPackages.jsp");
            System.out.println("Details only updated.");
        }

    }


}
