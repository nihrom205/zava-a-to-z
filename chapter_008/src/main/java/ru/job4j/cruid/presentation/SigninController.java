package ru.job4j.cruid.presentation;

import ru.job4j.cruid.dao.User;
import ru.job4j.cruid.logic.ValidateService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 20.09.18
 */
public class SigninController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/AutorizationView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User curentUser = new User(0, login, "", password, "");
        if (ValidateService.getInstance().isCreated(curentUser)) {
            User user = ValidateService.getInstance().findByLogin(curentUser);
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("curentUser", user);
//            resp.sendRedirect(String.format("%s/view", req.getContextPath()));
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "Credentional invalid");
            doGet(req, resp);
        }
    }
}
