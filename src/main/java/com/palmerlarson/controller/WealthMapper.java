package com.palmerlarson.controller;

import com.palmerlarson.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
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

/**
 * Main tool app for user to enter values
 */
@WebServlet(
        urlPatterns = {"/wealthMapper"}
)
public class WealthMapper extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * forward to wealthmapper
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoPage.pullName(req, resp, logger);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/wealthMapper.jsp");
        dispatcher.forward(req, resp);

    }

    /**
     * Generates the charts with user entered params
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        JSONArray arr = new JSONArray(br.readLine());

        try (OutputStream out = resp.getOutputStream()) {
            HttpSession session=req.getSession(false);
            User uObj = (User)session.getAttribute("currentUser");
            DefaultPieDataset<String> pieSet = new DefaultPieDataset<>();
            int totalDebt = 0;
            int totalWealth = 0;

            if (uObj.getGross_income() != 0) {
                int income = uObj.getGross_income();
                double mIncome = (double) income / 12;
                totalWealth += mIncome;
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
            }

            pieSet.setValue("Debt", totalDebt);
            pieSet.setValue("Wealth", totalWealth);

            JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", pieSet, true, true, false);

            resp.setContentType("image/png");

            ChartUtils.writeChartAsPNG(out, pieChart, 400, 300);
        } catch (Exception e) {
            logger.error(e.toString()); /* Throw exceptions to log files */
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wealthMapper.jsp");
        dispatcher.forward(req, resp);
    }

}