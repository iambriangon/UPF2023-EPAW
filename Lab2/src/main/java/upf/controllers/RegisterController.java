package upf.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import upf.managers.ManageUsers;
import upf.models.User;

/**
 * Servlet implementation class FormController
 */
@WebServlet(name = "RegisterController", value = "/RegisterController")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User model = new User();
        ManageUsers manager = new ManageUsers();

        String view = "index.jsp";

        try {
            BeanUtils.populate(model,request.getParameterMap());
            if (manager.isComplete(model)) {
                manager.addUser(model.getUser(), model.getMail(), model.getPwd1());
                manager.finalize();
                view = "registered.jsp";
            }

        } catch (IllegalAccessException | InvocationTargetException | SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("model", model);
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
