package ru.job4j.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.models.Item;
import ru.job4j.services.DBStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.12.2018
 */
public class ServletJson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> listItems = DBStore.getInstance().getAllItems();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString  = mapper.writeValueAsString(listItems);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(jsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        sb.append(reader.readLine());
        Item curentItem = mapper.readValue(sb.toString(), Item.class);
        DBStore.getInstance().addItem(curentItem);
    }
}
