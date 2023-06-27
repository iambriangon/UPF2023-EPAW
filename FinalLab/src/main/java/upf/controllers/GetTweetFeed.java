package upf.controllers;

import upf.managers.ManageTweets;
import upf.models.Tweet;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "GetTweetFeed", value = "/GetTweetFeed")
public class GetTweetFeed extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        System.out.println("Getting Tweet Feed: ");

        List<Tweet> tweets = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        ManageTweets tweetManager = new ManageTweets();


        if (session.getAttribute("user") == null) {
            // If user anon get last published tweets
            System.out.println("!!!TweetFeed Anon User!!!!!");
            tweets = tweetManager.getAllUserTweets(5);
        }
        else {
            // If user logged in get tweets of followers
            tweets = tweetManager.getUserFollowedTweets(user.getId(),0,4);
        }
        tweetManager.finalize();
        request.setAttribute("tweets", tweets);


        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTweetFeed.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
