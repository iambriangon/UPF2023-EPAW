package upf.controllers;

import org.apache.commons.beanutils.BeanUtils;
import upf.managers.ManageTweets;
import upf.models.Tweet;
import upf.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "GetOtherUserTweets", value = "/GetOtherUserTweets")
public class GetOtherUserTweets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        List<Tweet> tweets = Collections.emptyList();
        User user = new User();

        try {
            BeanUtils.populate(user, request.getParameterMap());
            ManageTweets tweetManager = new ManageTweets();
            tweets = tweetManager.getUserTweets(user.getId(),0,4);
            tweetManager.finalize();
            request.setAttribute("tweets", tweets);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTweetFeed.jsp");
            dispatcher.forward(request,response);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
