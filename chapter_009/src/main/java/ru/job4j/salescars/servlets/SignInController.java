package ru.job4j.salescars.servlets;

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
 * @since 10.01.2019
 */
public class SignInController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/Autorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String passwd = req.getParameter("passwd");
//        User currentUser = CarUserValidateImpl.getInstance().findCarUserLogimPassword(new User(login, passwd));
//        if (currentUser != null) {
            HttpSession session = req.getSession();
//            session.setAttribute("login", currentUser.getLogin());
//            session.setAttribute("user", currentUser);
//            resp.sendRedirect(String.format("%s/WEB-INF/views/ViewUserCar.jsp", req.getContextPath()));
            req.getRequestDispatcher("WEB-INF/views/ViewUserCar.jsp").forward(req, resp);

//        } else {
//            req.setAttribute("error", "Credentional invalid");
//            doGet(req, resp);
//        }
    }
}
