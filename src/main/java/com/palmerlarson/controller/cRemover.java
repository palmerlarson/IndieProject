package com.palmerlarson.controller;

import com.palmerlarson.entity.Tool;
import com.palmerlarson.persistence.ToolDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class used to remove chart from list
 */
@WebServlet(
        urlPatterns = {"/cRemover"}
)
public class cRemover extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoPage.pullName(req, resp, logger);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/graphs.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Post removes chart via the dao
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        int i = Integer.parseInt(br.readLine());
        ToolDao tDao = new ToolDao();
        Tool retrieveTool = tDao.getById(i);
        tDao.delete(retrieveTool);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/graphs.jsp");
        dispatcher.forward(req, resp);

    }



}
