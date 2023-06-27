package upf.controllers;

import upf.managers.ManageUsers;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateUsername", value = "/UpdateUsername")
public class UpdateUsername extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        System.out.println("Update Username: ");
        boolean error = true;
        String message = "Error";

        String newName = request.getParameter("content");
        User user = (User) session.getAttribute("user");
        ManageUsers userManager = new ManageUsers();
        error = userManager.updateUsername(user.getId(), newName);

        if(!error) {
            user.setName(newName);
            session.setAttribute("user", user);
            message="Success";
        }

        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewSettings.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
