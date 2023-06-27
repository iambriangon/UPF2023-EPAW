package upf.controllers;
import upf.managers.ManageTweets;
import upf.models.User;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "GetMyMovies", value = "/GetMyMovies")
public class GetMyMovies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Getting Popular Movies: ");
        List<String> movies = Collections.emptyList();
        ManageTweets tweetManager = new ManageTweets();

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        movies = tweetManager.getMyMovies(user.getId(), 20);

        request.setAttribute("movies", movies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewMyMovies.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}