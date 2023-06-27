package upf.controllers;

import upf.managers.ManageUsers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "UpdateUserAdmin", value = "/UpdateUserAdmin")
public class UpdateUserAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Update User Admin: ");
        ManageUsers userManager = new ManageUsers();

        HashMap<String, Boolean> error = new HashMap<>();
        HashMap<String, String> errorMessage = new HashMap<>();

        error.put("userid", false);
        error.put("email", false);
        error.put("phone", false);
        error.put("pwd", false);

        String userId = request.getParameter("userId");
        String newEmail = request.getParameter("email");
        String newPhone = request.getParameter("phone");
        String newPassword = request.getParameter("pwd");

        if(userManager.checkUserById(userId)) { // If user is registered
            if (!newPhone.isEmpty()) {
                error.put("phone", true);
                if (userManager.updatePhone(Integer.parseInt(userId), newPhone)){
                    errorMessage.put("phone", "The phone is taken or the update failed!");
                }
                else {
                    errorMessage.put("phone", "The phone is updated successfully");
                }
            }


            if (!newPassword.isEmpty()){
                error.put("pwd", true);
                if (userManager.updatePassword(Integer.parseInt(userId), newPassword)){
                    errorMessage.put("pwd", "The password is not valid or the update failed!");
                }
                else {
                    errorMessage.put("pwd", "The password is updated successfully");
                }
            }

            if (!newEmail.isEmpty()) {
                error.put("email", true);
                if (userManager.updateEmail(Integer.parseInt(userId), newEmail)){
                    errorMessage.put("email", "The email is taken or the update failed");
                }
                else {
                    errorMessage.put("email", "The email is updated successfully");
                }
            }
        }
        else {
            error.put("userid", true);
            errorMessage.put("userid", "The user is not registered hence cannot be modified!");
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
