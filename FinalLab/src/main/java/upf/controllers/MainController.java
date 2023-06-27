package upf.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainController", value = "/MainController")
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session==null || session.getAttribute("user")==null) {
            System.out.println("MainController: NO active session has been found.");
            request.setAttribute("content","ViewLandingPage.jsp");
        }
        else {
            System.out.println("Main Controller: active session has been found.");
            request.setAttribute("content","ViewFeedLogin.jsp");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
