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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.12.2018
 */
public class ServletJson extends HttpServlet {
//    private ConcurrentHashMap<String, String> mapItem = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        List<Item> listItems = DBStore.getInstance().getAllItems();
//        listItems.forEach(item1 -> System.out.println(item1.getDesc()));
        ObjectMapper mapper = new ObjectMapper();
        String jsonString  = mapper.writeValueAsString(listItems);
//        System.out.println(jsonString);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(jsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        sb.append(reader.readLine());
        Item curentItem = mapper.readValue(sb.toString(), Item.class);

        DBStore.getInstance().addItem(curentItem);
    }
}
