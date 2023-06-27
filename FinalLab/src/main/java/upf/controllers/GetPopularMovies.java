package upf.controllers;
import upf.managers.ManageTweets;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "GetPopularMovies", value = "/GetPopularMovies")
public class GetPopularMovies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Getting Popular Movies: ");
        List<String> movies = Collections.emptyList();
        ManageTweets tweetManager = new ManageTweets();
        movies = tweetManager.getPopularMovies(5);

        request.setAttribute("movies", movies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPopularMovies.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
