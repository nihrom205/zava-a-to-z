package ru.job4j.salescars.logic;

import ru.job4j.salescars.models.User;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 11.01.2019
 */
public interface Validate {
    void add(User user);
    void delete(User user);
    void update(User user);
    List<User> getAllCarUser();
    User findCarUserLogimPassword(User user);
    User findCarUserLogin(User user);
}
