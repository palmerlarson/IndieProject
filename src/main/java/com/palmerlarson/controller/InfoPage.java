package com.palmerlarson.controller;

import com.palmerlarson.entity.User;
import com.palmerlarson.persistence.UserDao;
import com.palmerlarson.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Main profile page for returning and updating profile information
 */
@WebServlet(
        urlPatterns = {"/infoPage"}
)
public class InfoPage extends HttpServlet implements PropertiesLoader {


    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * forward infoPage
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        pullName(req, resp, logger);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/infoPage.jsp");
        dispatcher.forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("fName");
        String lastName = req.getParameter("lName");
        int grossIncome = Integer.parseInt(req.getParameter("income"));
        HttpSession session=req.getSession(true);
        User uObj = (User)session.getAttribute("currentUser");
        UserDao dao = new UserDao();

        if (firstName != null && lastName != null && grossIncome != 0) {
            uObj.setFirst_name(firstName);
            uObj.setLast_name(lastName);
            uObj.setGross_income(grossIncome);
            dao.saveOrUpdate(uObj);
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/infoPage");
        dispatcher.forward(req, resp);
    }


    public static void pullName(HttpServletRequest req, HttpServletResponse resp, Logger logger) {
        try {
            resp.setContentType("text/html");
            HttpSession session=req.getSession(true);
            User uObj = (User)session.getAttribute("currentUser");
            String uName = uObj.getUserName();
            String fName = uObj.getFirst_name();
            String lName = uObj.getLast_name();
            int income = uObj.getGross_income();
            int monthlyIncome = income / 12;
            req.setAttribute("mIncome", monthlyIncome);
            req.setAttribute("userName", uName);
            req.setAttribute("fName", fName);
            req.setAttribute("lName", lName);
            req.setAttribute("income", income);
        } catch(Exception e){
            logger.error("INFO" + e);
        }
    }



}
