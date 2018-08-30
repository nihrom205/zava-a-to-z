package ru.job4j.cruid.presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.log4j.Logger;
import ru.job4j.cruid.dao.User;
import ru.job4j.cruid.logic.ValidateService;

/**
 * Class сервлетов.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 26.08.18
 */
public class UserServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pr = resp.getWriter();
        List<User>  list = ValidateService.getInstance().findAll();
        for (User user : list) {
            pr.write(user.getId() + " -" + user.getName() + "\n");
        }
        pr.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        String strId = req.getParameter("id");
        int id = (strId.equals("") ? 0 : Integer.valueOf(strId));
        switch (action) {
            case "add":
                ValidateService.getInstance().add(name);
                break;
            case "update":
                logger.info("добвлен: " + action + ", " + name + ", " + id);
                ValidateService.getInstance().update(id, name);
                break;
            case "delete":
                ValidateService.getInstance().delete(id);
                break;
            default:
                break;
        }
    }
}
