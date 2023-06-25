package upf.controllers;

import org.apache.commons.beanutils.BeanUtils;
import upf.managers.ManageUsers;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "RegisterController", value = "/RegisterController")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.print("RegisterController: ");
        User user = new User();
        ManageUsers manager = new ManageUsers();
        boolean cn = false;
        boolean cm = false;
        boolean cp = false;

        try {

            BeanUtils.populate(user, request.getParameterMap());

            cn = manager.checkUser(user.getName());
            cm = manager.checkMail(user.getMail());
            cp = manager.checkPhone(user.getPhoneNumber());

            user.setError("name", cn);
            user.setError("mail", cm);
            user.setError("phoneNumber", cp);

            if (manager.isComplete(user) && !cn && !cm && !cp) {
                manager.addUser(user);
                manager.finalize();
                System.out.println(" user ok, forwarding to ViewLoginForm.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLoginForm.jsp");
                dispatcher.forward(request, response);
            }

            else {
                System.out.println(" forwarding to ViewRegisterForm.");
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ViewRegisterForm.jsp");
                dispatcher.forward(request, response);
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
