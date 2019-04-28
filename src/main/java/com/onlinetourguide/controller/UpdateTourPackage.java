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

        String tour_name = request.getParameter("name");
        String location_from = request.getParameter("from");
        String location_to = request.getParameter("to");
        String date = request.getParameter("date");
        String price = request.getParameter("price");
        String desp1 = request.getParameter("desp1");
        String desp2 = request.getParameter("desp2");

        Part filePart = request.getPart("file");
        Part filePart2 = request.getPart("file1");

        TourPkgUpdateDao pkgUpdateDao = new TourPkgUpdateDao();

        if (filePart != null && filePart2 != null) {
            imageUrl_1 = filePart.getInputStream();
            imageUrl_2 = filePart2.getInputStream();
            pkgUpdateDao.UpdatePackageImage(tour_name,location_from,location_to,date,price,desp1,desp2,imageUrl_1,imageUrl_2);
            System.out.println("All updated");

        }
        else if (filePart != null)
        {
            imageUrl_1 = filePart.getInputStream();
            pkgUpdateDao.UpdatePackageImageOne(tour_name,location_from,location_to,date,price,desp1,desp2,imageUrl_1);
            System.out.println("Image 1 Updated");
        }
        else if (filePart2 != null)
        {
            imageUrl_2 = filePart.getInputStream();
            pkgUpdateDao.UpdatePackageImageTwo(tour_name,location_from,location_to,date,price,desp1,desp2,imageUrl_2);
            System.out.println("Image 2 Updated");

        }

        else {
            pkgUpdateDao.UpdatePackageNoImage(tour_name,location_from,location_to,date,price,desp1,desp2);
            System.out.println("No Image Update");
        }

    }


}
