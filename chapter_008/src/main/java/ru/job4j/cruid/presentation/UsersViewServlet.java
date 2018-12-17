package ru.job4j.cruid.presentation;

import ru.job4j.cruid.dao.User;
import ru.job4j.cruid.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class сервлетов.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 26.08.18
 */
public class UsersViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User curentUser = (User) session.getAttribute("curentUser");
        if (curentUser.getRole().equals("admin")) {
            req.setAttribute("users", ValidateService.getInstance().findAll());
            req.getRequestDispatcher("WEB-INF/views/UserViewRoot.jsp").forward(req, resp);
        } else {
            List<User> list = new LinkedList<>();
            list.add(ValidateService.getInstance().findByLogin(curentUser));
            req.setAttribute("users", list);
            req.getRequestDispatcher("WEB-INF/views/UserView.jsp").forward(req, resp);
        }

    }
}
