package com.palmerlarson.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
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
import java.io.*;
import java.util.Objects;

@WebServlet(
        urlPatterns = {"/wealthMapper"}
)
public class WealthMapper extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoPage.pullName(req, resp, logger);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wealthMapper.jsp");
        dispatcher.forward(req, resp);



    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        JSONArray arr = new JSONArray(br.readLine());

//        PrintWriter out = resp.getWriter();
//        out.print(arr);
        try (OutputStream out = resp.getOutputStream()) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            DefaultPieDataset<String> pieSet = new DefaultPieDataset<>();
            int totalDebt = 0;
            int totalWealth = 0;
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
                dataset.addValue(amount, name, type);
                pieSet.setValue("Debt", amount);
            }

            pieSet.setValue("Debt", totalDebt);
            pieSet.setValue("Wealth", totalWealth);

            JFreeChart barChart = ChartFactory.createBarChart("W&D Bar Chart", "Wealth & Debt", "Amount",
                    dataset, PlotOrientation.VERTICAL, true, true, false);

            JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", pieSet, true, true, false);

            ChartUtils.saveChartAsPNG(new File("/Users/palmerlarson/IdeaProjects/IndieProject/src/main/webapp/images/GraphCharts/barChart.png"), barChart, 650, 400);
            ChartUtils.saveChartAsPNG(new File("/Users/palmerlarson/IdeaProjects/IndieProject/src/main/webapp/images/GraphCharts/pieChart.png"), pieChart, 650, 400);

            resp.setContentType("image/png");

            ChartUtils.writeChartAsPNG(out, pieChart, 400, 300);
        } catch (Exception e) {
            System.err.println(e.toString()); /* Throw exceptions to log files */
        }
        /* Close the output stream */

        // 4. Set response type to JSON
//        resp.setContentType("application/json");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/wealthMapper.jsp");
        dispatcher.forward(req, resp);
    }
}