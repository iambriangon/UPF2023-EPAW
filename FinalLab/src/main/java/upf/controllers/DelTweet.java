package upf.controllers;

import org.apache.commons.beanutils.BeanUtils;
import upf.managers.ManageTweets;
import upf.models.Tweet;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "DelTweet", value = "/DelTweet")
public class DelTweet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Tweet tweet = new Tweet();
        ManageTweets tweetManager = new ManageTweets();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        try {
            if (session != null || user != null) {
                BeanUtils.populate(tweet, request.getParameterMap());
                tweetManager.deleteTweet(tweet.getId(),user.getId());
                tweetManager.finalize();
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
