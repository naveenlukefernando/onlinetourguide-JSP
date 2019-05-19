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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "SearchPkg",urlPatterns = {"/SearchPkg"})
public class SearchPkg extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String city = request.getParameter("city");
        String checkinDate = request.getParameter("checkIndate");
        String checkOutDate = request.getParameter("checkout");



        HttpSession session = request.getSession();
        int duration = 0;
        SimpleDateFormat myFormat = new SimpleDateFormat("MM/DD/yyyy");


        try {
            java.util.Date date1 =  myFormat.parse(checkinDate);
            Date date2 =  myFormat.parse(checkOutDate);
            long diff = date2.getTime() - date1.getTime();

                duration = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);





        } catch (ParseException e) {
            e.printStackTrace();
        }

        session.setAttribute("city",city);
        session.setAttribute("duration",duration);
        response.sendRedirect("searchPackages.jsp");






    }


}
