package ru.job4j;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 29.12.2018
 */
public interface Storage {
    void add(User user);
    void update(User user);
    void delete(User user);
    List<User> getAll();
}
