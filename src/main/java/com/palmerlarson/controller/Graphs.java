package com.palmerlarson.controller;

import com.palmerlarson.entity.Tool;
import com.palmerlarson.entity.User;
import com.palmerlarson.persistence.ToolDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Class used as practice - will be used as main graph creation class
 */
@WebServlet(
        urlPatterns = {"/graphs"}
)
public class Graphs extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoPage.pullName(req, resp, logger);



        RequestDispatcher dispatcher = req.getRequestDispatcher("/graphs.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        JSONArray arr = new JSONArray(br.readLine());
        HttpSession session=req.getSession(false);
        User uObj = (User)session.getAttribute("currentUser");
        ToolDao tDao = new ToolDao();
        int totalDebt = 0;
        int totalWealth = 0;

        try {
            if (uObj.getGross_income() != 0) {
                int income = uObj.getGross_income();
                double mIncome = (double) income / 12;
                totalWealth += mIncome;
            }

            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                String type = obj.getString("type");
                String strAmount = obj.getString("amount");
                int amount = Integer.parseInt(strAmount);

                if (Objects.equals(type, "wealth")) {
                    totalWealth += amount;
                } else if (Objects.equals(type, "debt")) {
                    totalDebt += amount;
                }
            }

            Tool tool = new Tool(totalWealth, totalDebt, uObj);
            tDao.insert(tool);

        } catch (Exception e) {
            System.err.println(e.toString()); /* Throw exceptions to log files */
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/graphs.jsp");
        dispatcher.forward(req, resp);
    }



}
