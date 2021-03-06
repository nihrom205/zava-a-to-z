package ru.job4j.cruid.persistent;
import ru.job4j.cruid.dao.Role;
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
    User add(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    User findById(User user);
    User findByLogin(User user);
    List<Role> findAllRoles();
    void addRole(Role role);
    void delRole(Role role);
}
