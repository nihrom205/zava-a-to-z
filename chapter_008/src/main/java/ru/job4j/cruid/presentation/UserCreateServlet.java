package ru.job4j.cruid.presentation;

import ru.job4j.cruid.dao.User;
import ru.job4j.cruid.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 31.08.18
 */
public class UserCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getContextPath();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pr = resp.getWriter();
        pr.write("<h3>Создание пользователя:</h3>" +
                    "<form action='/chapter_008/create' method='post'>" +
                    "<label>Имя пользователя: </label>" +
                    "<input type='text' size='40' name='textName'>" +
                    "<input type='submit' value='Create'>" +
                    "</form>");
        pr.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("textName");
        ValidateService.getInstance().add(name);
//        resp.sendRedirect(req.getContextPath() + "/list");
        req.getRequestDispatcher( "/list").forward(req, resp);
//        resp.
    }
}
