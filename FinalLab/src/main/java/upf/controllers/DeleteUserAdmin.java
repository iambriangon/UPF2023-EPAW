package upf.controllers;

import upf.managers.ManageTweets;
import upf.managers.ManageUsers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "DeleteUserAdmin", value = "/DeleteUserAdmin")
public class DeleteUserAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Delete User Admin: ");
        ManageUsers userManager = new ManageUsers();

        HashMap<String, Boolean> error = new HashMap<>();
        HashMap<String, String> errorMessage = new HashMap<>();

        String userId = request.getParameter("userId");

        if(userManager.deleteUserById(Integer.valueOf(userId))) {// If user is registered
            error.put("userid", true);
            errorMessage.put("userid", "The user is deleted!");
        }
        else {
            error.put("userid", true);
            errorMessage.put("userid", "The user id is not correct hence cannot be deleted!");
        }

        request.setAttribute("error", error);
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAdmin.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
