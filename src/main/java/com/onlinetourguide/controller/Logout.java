package com.onlinetourguide.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String level = (String) session.getAttribute("username");

        if (level == null) {

            session.removeAttribute("admin_username");
            session.removeAttribute("aid");
            session.invalidate();
            response.sendRedirect("indexc.jsp");
        } else {
            session.removeAttribute("username");
            session.removeAttribute("cid");
            session.invalidate();
            response.sendRedirect("indexc.jsp");

        }


    }
}

