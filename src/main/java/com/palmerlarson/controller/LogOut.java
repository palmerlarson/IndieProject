package com.palmerlarson.controller;

import com.palmerlarson.util.PropertiesLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * logs/signs out
 */
@WebServlet(
        urlPatterns = {"/logOut"}
)
public class LogOut extends HttpServlet implements PropertiesLoader {
    /**
     * ends sessions
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        getServletContext().getRequestDispatcher("/loggedOut.jsp").forward(req, resp);
    }


}
