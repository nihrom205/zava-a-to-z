package ru.job4j.salescars.servlets;

import ru.job4j.salescars.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 14.01.2019
 */
public class ViewAutorizUserCarJsonServlet extends HttpServlet {
    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = (String)req.getAttribute("login");
        HttpSession session = req.getSession();
        User user1 = (User) session.getAttribute("user");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();

        sb.append(reader.readLine());
        User carUser = new User();
//        carUser.setLogin(sb.toString());
//        User user = CarUserValidateImpl.getInstance().findCarUserLogin(carUser);

//        List<Car> cars = user.getCars();
//        for (Car car : cars) {
////            String[] keyValut = car.split("=");
//            map.put("marka", keyValut[1]);
//        }

//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(cars);
//        resp.setContentType("text/json");
//        PrintWriter write = new PrintWriter(resp.getOutputStream());
////        write.append("[");
//        write.append(jsonString);
////        write.append("]");
//        write.flush();

//        super.doPost(req, resp);
    }
}
