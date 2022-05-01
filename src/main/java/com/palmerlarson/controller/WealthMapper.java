package com.palmerlarson.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/wealthMapper"}
)
public class WealthMapper extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String incomeName = req.getParameter("iName");
//        int grossIncome = Integer.parseInt(req.getParameter("iAmount"));
//
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.println("<h1>Your profile has been fully setup!</h1>");
//        out.println("<p>Username:" + "holder" + "</p>");
//        out.println("<p>Name:" + incomeName + " " + grossIncome + "</p>");
//        out.println("<p>Email: " + "holder" + "</p>");
//        out.println("<p>Income: " + grossIncome + "</p>");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wealthMapper.jsp");
        dispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String incomeName = req.getParameter("iName");
        int grossIncome = Integer.parseInt(req.getParameter("iAmount"));

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Your profile has been fully setup!</h1>");
        out.println("<p>Username:" + "holder" + "</p>");
        out.println("<p>Name:" + incomeName + " " + grossIncome + "</p>");
        out.println("<p>Email: " + "holder" + "</p>");
        out.println("<p>Income: " + grossIncome + "</p>");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wealthMapper.jsp");
        dispatcher.forward(req, resp);


    }
}