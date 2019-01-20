package ru.job4j.salescars.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.salescars.models.Car;
import ru.job4j.salescars.service.impl.DBStoreImpl;

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
 * @since 13.01.2019
 */
public class ReadViewAllJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = DBStoreImpl.getInstance().getAllCar();

        int n = System.identityHashCode(new Object());
        long n2 = System.currentTimeMillis();
        long n3 = System.identityHashCode(n2);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(cars);
        resp.setContentType("text/json");
        PrintWriter write = new PrintWriter(resp.getOutputStream());
        write.append(jsonString);
        write.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);
    }
}
