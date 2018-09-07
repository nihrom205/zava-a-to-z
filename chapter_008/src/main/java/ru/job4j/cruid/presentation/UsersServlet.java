package ru.job4j.cruid.presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class сервлетов.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 26.08.18
 */
public class UsersServlet extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter pr = resp.getWriter();
//        List<User>  list = ValidateService.getInstance().findAll();
//        pr.write("<!DOCTYPE html>" +
//                    "<html lang='en'>" +
//                    "<head>" +
//                    "<meta charset='UTF-8'>" +
//                    "<title>Список пользователей</title>" +
//                    "</head>" +
//                    "<body>" +
//                    "<form aciton='/chapter_008/create' method='post'>" +
//                        "<input type='submit' value='Add user'>" +
//                    "</form>" +
//                    "<table border='1'>"+
//                    "<tr>" +
//                        "<th>id</th>" +
//                        "<th>name</th>" +
//                        "<th></th>" +
//                    "</tr>");
//        for (User user : list) {
//            pr.write("<tr>" +
//                            "<td width=50>" + user.getId() + "</td>" +
//                            "<td width=50>" + user.getName() + "</td>" +
//                            "<td width=100>" +
//                            "<form action='/chapter_008/edit' method='get'>" +
//                                "<input type='hidden' name='id' value='" + user.getId() + "'>" +
//                                "<input type='submit' value='Edit'>" +
//                            "</form>"+
//
//                            "<form action='/chapter_008/delete' method='post'>" +
//                                "<input type='hidden' name='id' value='" + user.getId() + "'>" +
//                                "<input type='submit' value='Del'>" +
//                    "       </form>"+
//                            "</td>" +
//                        "</tr>");
//        }
//        pr.write("</table>" +
//                    "</body>" +
//                    "</html>");
//        pr.flush();
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect(req.getContextPath() + "/create");
    }
}
