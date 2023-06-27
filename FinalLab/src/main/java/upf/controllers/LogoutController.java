package upf.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutController", value = "/LogoutController")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        System.out.println("LogoutController: deleting session and forwarding to ViewLandingPage");


        if (session!=null) {
            session.invalidate();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLandingPage.jsp");
        if (dispatcher != null) dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
