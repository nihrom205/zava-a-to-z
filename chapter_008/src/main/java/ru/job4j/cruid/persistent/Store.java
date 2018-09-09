package ru.job4j.cruid.persistent;
import ru.job4j.cruid.dao.User;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 30.08.18
 */
public interface Store<User> {
    void add(User user);
    void update(User user);
    void delete(int id);
    List<User> findAll();
    User findById(int id);
}
