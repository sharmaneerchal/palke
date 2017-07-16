package com.myapp.struts.transaction;

import com.google.gson.Gson;
import com.myapp.struts.dao.MembersDAO;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mappings.Members;

public class Controller
        extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*  37 */ response.setContentType("text/html;charset=UTF-8");
        /*  38 */ PrintWriter out = response.getWriter();
        try {
            /*  41 */ out.println("<!DOCTYPE html>");
            /*  42 */ out.println("<html>");
            /*  43 */ out.println("<head>");
            /*  44 */ out.println("<title>Servlet Controller</title>");
            /*  45 */ out.println("</head>");
            /*  46 */ out.println("<body>");
            /*  47 */ out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            /*  48 */ out.println("</body>");
            /*  49 */ out.println("</html>");
        } finally {
            /*  51 */ out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*  68 */ response.setContentType("application/json");
        try {
            /*  70 */ String term = request.getParameter("term");
            /*  71 */ HttpSession session = request.getSession();
            /*  72 */ int groupid = Integer.parseInt(session.getAttribute("groupid").toString());
            /*  73 */ System.out.println("Data from ajax call " + term);

            /*  75 */ List<Members> lstMembers = new MembersDAO().getMembers(groupid, term);

            /*  77 */ List<String> list = new ArrayList();
            /*  78 */ for (int i = 0; i < lstMembers.size(); i++) {
                /*  79 */ Members members = (Members) lstMembers.get(i);
                /*  80 */ list.add(members.getMemberno() + "-" + members.getMembername());
            }

            /*  89 */ String searchList = new Gson().toJson(list);
            /*  90 */ response.getWriter().write(searchList);
        } catch (Exception e) {
            /*  92 */ System.err.println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* 107 */ processRequest(request, response);
    }

    public String getServletInfo() {
        /* 117 */ return "Short description";
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\transaction\Controller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
