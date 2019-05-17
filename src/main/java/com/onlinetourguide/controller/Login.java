package com.onlinetourguide.controller;

import com.onlinetourguide.dao.LoginDao;
import com.onlinetourguide.dao.UsersFetchDao;
import com.onlinetourguide.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    private static User user;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        LoginDao dao = new LoginDao();


        if (dao.check(uname, pass)) {
            HttpSession session = request.getSession();
            int id = dao.getId();
            user = new UsersFetchDao().fetchCustomer(id);

            if (1 == dao.getUserLevel()) {
                session.setAttribute("admin_username", uname);
                session.setAttribute("aid", user);
                response.sendRedirect("index.jsp");
            } else {
                session.setAttribute("username", uname);
                session.setAttribute("cid", user);
                response.sendRedirect("indexc.jsp");
            }

        } else {
            request.setAttribute("error", "error");
            RequestDispatcher rd = request.getRequestDispatcher("loginerror.jsp");
            rd.forward(request, response);

        }
    }

}
