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
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", ValidateService.getInstance().findById(new User(Integer.valueOf(req.getParameter("id")), "", "", "")));
        req.setAttribute("roles", ValidateService.getInstance().findAllRoles());
        req.setAttribute("sessiaUser", (User) req.getSession().getAttribute("curentUser"));
        req.getRequestDispatcher("WEB-INF/views/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String role = req.getParameter("roles");
        ValidateService.getInstance().update(new User(id, name, email, pass, role));
        resp.sendRedirect(String.format("%s", req.getContextPath()));
    }
}
