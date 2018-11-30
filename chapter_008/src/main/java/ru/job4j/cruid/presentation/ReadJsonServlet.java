package ru.job4j.cruid.presentation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cruid.dao.UserPOJO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 17.11.2018
 */
public class ReadJsonServlet extends HttpServlet {
    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter write = new PrintWriter(resp.getOutputStream());
        write.append("[{\"login\":1,\"email\":2}, {\"login\":3,\"email\":4}]");
        write.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();

        sb.append(reader.readLine());
        List<String> list = Arrays.asList(sb.toString().split("&"));
        for (String s : list) {
            String[] keyValut = s.split("=");
            map.put(keyValut[0], keyValut[1]);
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(new UserPOJO(map.get("name"), map.get("lastName"), map.get("gender"), map.get("description")));
        resp.setContentType("text/json");
        PrintWriter write = new PrintWriter(resp.getOutputStream());
        write.append("[");
        write.append(jsonString);
        write.append("]");
        write.flush();
    }
}
