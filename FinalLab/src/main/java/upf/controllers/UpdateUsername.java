package upf.controllers;

import upf.managers.ManageUsers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateUsername", value = "/UpdateUsername")
public class UpdateUsername extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean error = true;
        System.out.println("Update Username: ");

        ManageUsers userManager = new ManageUsers();

        String newUser = request.getParameter("content");
        System.out.println("New User is: " + newUser);

        request.setAttribute("error", error);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewSettings.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
