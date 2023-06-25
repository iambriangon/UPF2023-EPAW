package upf.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AnonLoginController", value = "/AnonLoginController")
public class AnonLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        System.out.println("AnonLoginController: View Feed as Anon");
        if (session!=null) {
            session.invalidate();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewFeedAnonymous.jsp");
        if (dispatcher != null) dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
