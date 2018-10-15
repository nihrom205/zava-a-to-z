package ru.job4j.cruid.logic;

import ru.job4j.cruid.dao.Role;
import ru.job4j.cruid.dao.User;
import ru.job4j.cruid.persistent.DBStore;
import ru.job4j.cruid.persistent.MemoryStore;
import ru.job4j.cruid.persistent.Store;

import java.util.List;

/**
 * Class бизнес логики.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 30.08.18
 */
public class ValidateService {
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
     * @param name
     */
    public void add(String name, String email) {
        if (name.equals("") || store.findAll().contains(new User(0, name, email, ""))) {
            return;
        }
        store.add(new User(id++, name, email, ""));
    }

    public void update(int id, String name, String email, String pass, String role) {
        store.update(new User(id, name, email, pass, role));
    }

    public void delete(int id) {
        store.delete(id);
    }

    public List<User> findAll() {
        return store.findAll();
    }

    public User findById(int id) {
        return store.findById(id);
    }

    public boolean isCreated(String login, String password) {
        return store.findByLogin(login).equals(new User(0, login, null, password));
    }

    public User findByLogin(String login, String password) {
        return store.findByLogin(login);
    }

    public List<Role> findAllRoles() {
        return store.findAllRoles();
    }

    public void addRole(String name, String description) {
        store.addRole(name, description);
    }

    public void delRole(String id) {
        store.delRole(id);
    }
}
