package upf.controllers;

import upf.managers.ManageUsers;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetProfileOtherUsers", value = "/GetProfileOtherUsers")
public class GetProfileOtherUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("GetProfileOtherUsers: ");
        ManageUsers userManager = new ManageUsers();
        HttpSession session = request.getSession(false);
        String otherUserId = request.getParameter("id");
        String view = "ViewProfileOtherUsers.jsp";

        User otherUser = userManager.getUser(Integer.valueOf(otherUserId));

        request.setAttribute("otherUserId", String.valueOf(otherUser.getId()));
        request.setAttribute("otherUserName", otherUser.getName());
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
