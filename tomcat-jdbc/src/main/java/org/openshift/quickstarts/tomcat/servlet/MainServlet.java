package org.openshift.quickstarts.tomcat.servlet;

import org.openshift.quickstarts.tomcat.model.TomcatEntry;
import org.openshift.quickstarts.tomcat.service.TomcatService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 */
public class MainServlet extends HttpServlet {

    private TomcatService tomcatService = new TomcatService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().append("There is two chairs...");
        
    }

    private String escapeHtml(String text) {
        return text.replace("<", "&lt;");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String summary = req.getParameter("summary");
        String description = req.getParameter("description");

        tomcatService.addEntry(new TomcatEntry(summary, description));

        resp.sendRedirect("index.html");
    }
}
