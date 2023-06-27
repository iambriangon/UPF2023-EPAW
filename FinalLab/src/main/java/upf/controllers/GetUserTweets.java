package upf.controllers;

import upf.managers.ManageTweets;
import upf.models.Tweet;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "GetUserTweets", value = "/GetUserTweets")
public class GetUserTweets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        List<Tweet> tweets = Collections.emptyList();
        User user = (User) session.getAttribute("user");

        if (session != null || user != null) {
            ManageTweets tweetManager = new ManageTweets();
            tweets = tweetManager.getUserTweets(user.getId(),0,4);
            tweetManager.finalize();
        }

        request.setAttribute("tweets", tweets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTweetFeed.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
