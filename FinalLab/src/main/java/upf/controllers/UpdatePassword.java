package upf.controllers;

import upf.managers.ManageUsers;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePassword", value = "/UpdatePassword")
public class UpdatePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        System.out.println("Update Password: ");
        boolean error = true;
        String message = "Error";

        String newPass = request.getParameter("content");
        User user = (User) session.getAttribute("user");
        ManageUsers userManager = new ManageUsers();
        error = userManager.updatePassword(user.getId(), newPass);

        if(!error) {
            user.setPwd(newPass);
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
