package upf.controllers;

import org.apache.commons.beanutils.BeanUtils;
import upf.managers.ManageUsers;
import upf.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "UnfollowUser", value = "/UnfollowUser")
public class UnfollowUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User fuser = new User();
        ManageUsers userManager = new ManageUsers();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        try {

            if (session != null || user != null) {
                BeanUtils.populate(fuser, request.getParameterMap());
                userManager.unfollowUser(user.getId(), fuser.getId());
                userManager.finalize();
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
