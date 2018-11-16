package ru.job4j.cruid.logic;

import ru.job4j.cruid.dao.Role;
import ru.job4j.cruid.dao.User;
import ru.job4j.cruid.persistent.DBStore;
import ru.job4j.cruid.persistent.Store;

import java.util.List;

/**
 * Class бизнес логики.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 30.08.18
 */
public class ValidateService implements Validate {
    private static volatile ValidateService service = new ValidateService();
    private Store<User> store = DBStore.getInstance();
    private int id = 0;

    private ValidateService() {
//        this.store.add(new User(0, "root", "root@yahoo.com", "root"));
    }

    public static ValidateService getInstance() {
        return service;
    }

    /**
     * Метод добавляет
     * @param user
     */
    public User add(User user) {
        if (user.getName().equals("") || store.findAll().contains(user)) {
            return null;
        }
        return store.add(user);
    }

    public void update(User user) {
        store.update(user);
    }

    public void delete(User user) {
        store.delete(user);
    }

    public List<User> findAll() {
        return store.findAll();
    }

    public User findById(User user) {
        return store.findById(user);
    }

    public boolean isCreated(User user ) {
        return store.findByLogin(user).equals(user);
    }

    public User findByLogin(User user) {
        return store.findByLogin(user);
    }

    public List<Role> findAllRoles() {
        return store.findAllRoles();
    }

    public void addRole(Role role) {
        store.addRole(role);
    }

    public void delRole(Role role) {
        store.delRole(role);
    }
}
