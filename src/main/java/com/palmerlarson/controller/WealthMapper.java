package com.palmerlarson.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/wealthMapper"}
)
public class WealthMapper extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wealthMapper.jsp");
        dispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        JSONObject obj = new JSONObject();
//        req.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = br.readLine();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(json);


        // 4. Set response type to JSON
        resp.setContentType("application/json");

    }
}