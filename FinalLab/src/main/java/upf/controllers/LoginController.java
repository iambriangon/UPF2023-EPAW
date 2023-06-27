package upf.controllers;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.tuple.Pair;
import upf.managers.ManageUsers;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.print("LoginController: ");

        User user = new User();
        ManageUsers manager = new ManageUsers();
        String view = "ViewLoginForm.jsp";
        Pair<Boolean,User> pair = null;

        try {

            BeanUtils.populate(user, request.getParameterMap());

            if (manager.isLoginComplete(user)) {

                pair = manager.checkLogin(user);

                if (pair.getLeft()) {
                    System.out.println("login OK, forwarding to ViewFeedLogin ");
                    HttpSession session = request.getSession();
                    session.setAttribute("user", pair.getRight());
                    if (user.getName().equals("admin"))
                        view = "ViewAdmin.jsp";
                    else
                        view = "ViewFeedLogin.jsp";
                }

                else {
                    System.out.println("user is not logged (user not found), forwarding to ViewLoginForm ");
                    request.setAttribute("error", true);
                    request.setAttribute("user", user);
                }
            }

            else {
                System.out.println("user is not logged (first time), forwarding to ViewLoginForm ");
                request.setAttribute("user", user);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
