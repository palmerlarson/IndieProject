package com.palmerlarson.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.palmerlarson.entity.User;
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
import java.io.PrintWriter;

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

        PrintWriter out = resp.getWriter();
//        out.println(json);
        out.print(arr);


        // 4. Set response type to JSON
        resp.setContentType("application/json");

    }
}