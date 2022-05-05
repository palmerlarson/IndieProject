package com.palmerlarson.controller;

import com.palmerlarson.auth.CognitoJWTParser;
import com.palmerlarson.entity.User;
import com.palmerlarson.persistence.UserDao;
import com.palmerlarson.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.palmerlarson.auth.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;


public class InfoPage extends HttpServlet implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    public boolean isFullySetup = false;
    public String name = "";
    Properties properties;
    public static String CLIENT_ID;
    public static String LOGIN_URL;
    public static String REDIRECT_URL;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CLIENT_ID = properties.getProperty("client.id");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(CLIENT_ID);



        RequestDispatcher dispatcher = req.getRequestDispatcher("/infoPage.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("fName");
        String lastName = req.getParameter("lName");
        int grossIncome = Integer.parseInt(req.getParameter("income"));
        System.out.println(firstName + lastName + grossIncome);


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Your profile has been fully setup!</h1>");
        out.println("<p>Username:" + "holder" + "</p>");
        out.println("<p>Name:" + firstName + " " + lastName + "</p>");
        out.println("<p>Email: " + "holder" + "</p>");
        out.println("<p>Income: " + grossIncome + "</p>");


        if (!isFullySetup) {
            addToDatabase(firstName, lastName, "test", grossIncome);
            isFullySetup = true;
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
    }

    public void addToDatabase(String firstName, String lastName, String userEmail, int income) {
        UserDao dao = new UserDao();
        User newUser = new User(firstName, lastName, userEmail, income);
        dao.insert(newUser);
        logger.error("TEST DID THIS WORK?");

    }





}
