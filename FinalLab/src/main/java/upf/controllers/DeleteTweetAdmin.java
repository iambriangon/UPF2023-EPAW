package upf.controllers;

import upf.managers.ManageTweets;
import upf.managers.ManageUsers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "DeleteTweetAdmin", value = "/DeleteTweetAdmin")
public class DeleteTweetAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Delete Tweet Admin: ");
        ManageTweets tweetManager = new ManageTweets();

        HashMap<String, Boolean> error = new HashMap<>();
        HashMap<String, String> errorMessage = new HashMap<>();

        String tweetId = request.getParameter("tweetId");

        if(tweetManager.deleteTweetById(Integer.valueOf(tweetId))) {
            error.put("userid", true);
            errorMessage.put("userid", "The tweet has been deleted");
        }
        else {
            error.put("userid", true);
            errorMessage.put("userid", "The tweet id is not correct hence cannot be deleted!");
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
