package ru.job4j.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Клас конвектор из list в map.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 12.11.2017
 */
public class UserConvert {
    /**
     * метод преобразует список User в map,
     * где id пользователя заноситься в ключ map,
     * а занение map заноситься пользователь.
     * @param list список объектов User
     * @return заполненная карта
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
