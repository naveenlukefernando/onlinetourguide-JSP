package com.onlinetourguide.controller;

import com.onlinetourguide.dao.AddTourPackageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "AddNewTourPackage", urlPatterns = {"/AddNewTourPackage"})
@MultipartConfig
public class AddNewTourPackage extends HttpServlet {

    private InputStream imageUrl_1;
    private InputStream imageUrl_2;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String tour_name = request.getParameter("name");
        String location_from = request.getParameter("from");
        String location_to = request.getParameter("to");
        String date = request.getParameter("date");
        String price = request.getParameter("price");
        String desp1 = request.getParameter("desp1");
        String desp2 = request.getParameter("desp2");
//        String imageUrl_1 = request.getParameter("file");
//        String imageUrl_2 = request.getParameter("file1");

        // input stream of the upload file
        Part filePart = request.getPart("file");
        Part filePart2 = request.getPart("file1");

        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            imageUrl_1 = filePart.getInputStream();
            imageUrl_2 = filePart2.getInputStream();
        }

        AddTourPackageDao addTourPackageDao = new AddTourPackageDao();
        addTourPackageDao.addTourPackage(tour_name,location_from,location_to,date,price,desp1,desp2,imageUrl_1,imageUrl_2);

        response.sendRedirect("manageTourPackages.jsp");

    }


}
