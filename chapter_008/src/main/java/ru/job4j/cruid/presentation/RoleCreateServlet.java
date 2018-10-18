package ru.job4j.cruid.presentation;

import ru.job4j.cruid.dao.Role;
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
 * @since 15.10.18
 */
public class RoleCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        ValidateService.getInstance().addRole(new Role(0, name, desc));
        resp.sendRedirect(String.format("%s", req.getContextPath()));
    }
}
