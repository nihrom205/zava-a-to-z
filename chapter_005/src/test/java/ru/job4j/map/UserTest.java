package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Class <Name>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.12.17
 */
public class UserTest {

    @Test
    public void whenCreateUsersThenAdeddToMap() {
        Calendar calendar = Calendar.getInstance();
        User user1 = new User("Alexey", 2, calendar);
        User user2 = new User("Alexey", 2, calendar);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, null);
        map.put(user2, null);
        System.out.println(map);
        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}