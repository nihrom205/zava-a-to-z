package ru.job4j.cruid.presentation;

import ru.job4j.cruid.dao.User;
import ru.job4j.cruid.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        int id = Integer.valueOf(req.getParameter("id"));
        User user = ValidateService.getInstance().findById(id);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pr = resp.getWriter();
        pr.write("<!DOCTYPE html>" +
                "<html lang='en'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<title>Список пользователей</title>" +
                "</head>" +
                "<body>" +
                    "<form action='/chapter_008/edit' method='post'>" +
                        "<label>id:</label>" +
                        "<input type='text' name='id' value='" + user.getId() +"' size='10' readonly>" +
                        "<label>name:</label>" +
                        "<input type='text' name='name' value='" + user.getName() + "'>" +
                        "<input type='submit' value='Update'>" +
                    "</form>" +
                "</body>" +
                "</html>");
        pr.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        ValidateService.getInstance().update(id, name);
        resp.sendRedirect("/chapter_008/list");
    }
}
