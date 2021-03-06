package com.palmerlarson.controller;

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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * class used to generated saved charts from the db params
 */
@WebServlet(
        urlPatterns = {"/cGenerator"}
)
public class cGenerator extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *  forward /cGenerator
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoPage.pullName(req, resp, logger);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/cGenerator.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     *  Generates a new chart based on the pulled saved parameters from rds
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        JSONArray arr = new JSONArray(br.readLine());

        try (OutputStream out = resp.getOutputStream()) {
            DefaultPieDataset<String> pieSet = new DefaultPieDataset<>();
            JSONObject obj = arr.getJSONObject(0);
            int d = obj.getInt("debt");
            int w = obj.getInt("wealth");

            pieSet.setValue("Debt", d);
            pieSet.setValue("Wealth", w);

            JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", pieSet, true, true, false);

            resp.setContentType("image/png");

            ChartUtils.writeChartAsPNG(out, pieChart, 400, 300);
        }catch (Exception e) {
            logger.error(e.toString()); /* Throw exceptions to log files */
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/graphs.jsp");
        dispatcher.forward(req, resp);

    }
}
