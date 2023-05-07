package com.example.lab1;

import com.example.utils.DB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "database", value = "/database")
public class Database extends HttpServlet {
    private DB db;
    private String message;

    @Override
    public void init() {
        try {
            message = "Table results:";
            db = new DB();
            System.out.println("MySql connection correctly!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String q = "SELECT * FROM epaw.user";

        try {
            ResultSet results = db.executeSQL(q);

            out.println("<html>");
            out.println("<body>");

            out.println("<h1>" + message + "</h1>");

            out.println("<table border=1 >");
            out.println("<tr>");
            out.println("<th>Nom</th>");
            out.println("<th>Descripció</th>");
            out.println("<th>Telèfon</th>");
            out.println("</tr>");

            while(results.next()) {
                out.println("<tr>");
                out.println("<td>" + results.getString("nom") +"</td>");
                out.println("<td>" + results.getString("descripcio") +"</td>");
                out.println("<td>" + results.getString("telefon") +"</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void destroy() {
        try {
            db.disconnectBD();
            System.out.println("MySql connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
