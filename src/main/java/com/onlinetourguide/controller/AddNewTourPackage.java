package com.onlinetourguide.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "AddNewTourPackage")
public class AddNewTourPackage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String tour_name = request.getParameter("name");
        String location_from = request.getParameter("from");
        String location_to = request.getParameter("to");
        String date = request.getParameter("date");
        String price = request.getParameter("price");
        String desp1 = request.getParameter("desp1");
        String desp2 = request.getParameter("desp2");
        String imageUrl_1 = request.getParameter("file");
        String imageUrl_2 = request.getParameter("file1");


        File image1 = new File(imageUrl_1);
        File image2 = new File(imageUrl_2);



    }


}
