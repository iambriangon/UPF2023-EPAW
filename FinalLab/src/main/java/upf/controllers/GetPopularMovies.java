package upf.controllers;

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
        List<String> movies = new ArrayList<>();
        movies.add("Avatar");
        movies.add("Harry Potter");
        movies.add("Pokemon");
        movies.add("Avatar2");
        movies.add("Harry Potter2");
        movies.add("Pokemon2");

        request.setAttribute("movies", movies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPopularMovies.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
