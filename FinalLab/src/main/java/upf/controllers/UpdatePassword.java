package upf.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePassword", value = "/UpdatePassword")
public class UpdatePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean error = true;
        String newPass = request.getParameter("content");

        System.out.println("Update Password: ");
        System.out.println("New Password is: " + newPass);

        request.setAttribute("error", error);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewSettings.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
