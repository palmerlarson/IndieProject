package com.palmerlarson.controller;

import com.palmerlarson.entity.User;
import com.palmerlarson.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
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
import java.io.OutputStream;
import java.util.Objects;

@WebServlet(
        urlPatterns = {"/wealthMapper"}
)
public class WealthMapper extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoPage.pullName(req, resp, logger);
        HttpSession session=req.getSession(true);
//        User uObj =  (User)session.getAttribute("currentUser");
        UserDao dao = new UserDao();
        User uObj = dao.getById(1);
        int income = uObj.getGross_income();
        int monthlyIncome = income / 12;
        req.setAttribute("mIncome", monthlyIncome);



        RequestDispatcher dispatcher = req.getRequestDispatcher("/wealthMapper.jsp");
        dispatcher.forward(req, resp);



    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        JSONArray arr = new JSONArray(br.readLine());
        HttpSession session=req.getSession(true);
//        User uObj = (User)session.getAttribute("currentUser");
        UserDao dao = new UserDao();
        User uObj = dao.getById(1);

        try (OutputStream out = resp.getOutputStream()) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            DefaultPieDataset<String> pieSet = new DefaultPieDataset<>();
            int totalDebt = 0;
            int totalWealth = 0;

            if (uObj.getGross_income() != 0) {
                int income = uObj.getGross_income();
                totalWealth += income;
            }
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                String name = obj.getString("name");
                String type = obj.getString("type");
                String strAmount = obj.getString("amount");
                int amount = Integer.parseInt(strAmount);

                if (Objects.equals(type, "wealth")) {
                    totalWealth += amount;
                } else if (Objects.equals(type, "debt")) {
                    totalDebt += amount;
                }
                pieSet.setValue("Debt", amount);
            }

            pieSet.setValue("Debt", totalDebt);
            pieSet.setValue("Wealth", totalWealth);

            JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", pieSet, true, true, false);

            resp.setContentType("image/png");

            ChartUtils.writeChartAsPNG(out, pieChart, 400, 300);
        } catch (Exception e) {
            System.err.println(e.toString()); /* Throw exceptions to log files */
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wealthMapper.jsp");
        dispatcher.forward(req, resp);
    }

//
//    protected void evaluator(wealth, debt) {
//
//    }
}