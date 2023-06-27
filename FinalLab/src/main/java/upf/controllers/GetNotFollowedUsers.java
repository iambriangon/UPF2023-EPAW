package upf.controllers;

import upf.managers.ManageUsers;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "GetNotFollowedUsers", value = "/GetNotFollowedUsers")
public class GetNotFollowedUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = Collections.emptyList();

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        if (session != null || user != null) {

            ManageUsers userManager = new ManageUsers();
            users = userManager.getNotFollowedUsers(user.getId(),0,4);
            userManager.finalize();

        }

        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewNotFollowedUsers.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
