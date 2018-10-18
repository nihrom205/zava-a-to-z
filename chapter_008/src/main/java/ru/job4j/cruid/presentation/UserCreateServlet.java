package ru.job4j.cruid.presentation;

import ru.job4j.cruid.dao.User;
import ru.job4j.cruid.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 31.08.18
 */
public class UserCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        ValidateService.getInstance().add(new User(0 , name, email, password));
        resp.sendRedirect(String.format("%s", req.getContextPath()));
    }
}
