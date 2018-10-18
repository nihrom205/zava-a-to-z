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
public class RoleDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        ValidateService.getInstance().delRole(new Role(id, "", ""));
        resp.sendRedirect(String.format("%s/listrole", req.getContextPath()));
    }
}
