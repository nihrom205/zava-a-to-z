package ru.job4j.cruid.logic;

import ru.job4j.cruid.dao.Role;
import ru.job4j.cruid.dao.User;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 17.10.18
 */
public interface Validate {

    User add(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    User findById(User user);
    boolean isCreated(User user);
    User findByLogin(User user);
    List<Role> findAllRoles();
    void addRole(Role role);
    void delRole(Role role);

}
