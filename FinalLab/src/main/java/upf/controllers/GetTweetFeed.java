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

        List<Tweet> tweets2 = Collections.emptyList();
        //User user = (User) session.getAttribute("user");

        List<Tweet> tweets = new ArrayList<>();

        Tweet t1 = new Tweet();
        t1.setContent("My Favorite Movie is Creed 3");
        t1.setUname("Juanito");
        t1.setPostDateTime(new Timestamp(System.currentTimeMillis()));

        Tweet t2 = new Tweet();
        t2.setContent("My Favorite Movie is Creed 1");
        t2.setUname("Julius");
        t2.setPostDateTime(new Timestamp(System.currentTimeMillis()));

        Tweet t3 = new Tweet();
        t3.setContent("My Favorite Movie is Pokemon 1");
        t3.setUname("Julius");
        t3.setPostDateTime(new Timestamp(System.currentTimeMillis()));

        Tweet t4 = new Tweet();
        t4.setContent("My Favorite Movie is Mario Bros");
        t4.setUname("Jordi");
        t4.setPostDateTime(new Timestamp(System.currentTimeMillis()));

        if (session==null || session.getAttribute("user")==null) {
            // If user anon get last published tweets
            ManageTweets tweetManager = new ManageTweets();
            tweets2 = tweetManager.getAllUserTweets(5);
            tweetManager.finalize();
            request.setAttribute("tweets", tweets2);
        }
        else {
            // If user logged in get tweets of followers
            System.out.print("User Registered");

            tweets.add(t2);
            tweets.add(t3);
            request.setAttribute("tweets", tweets);
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTweetFeed.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
