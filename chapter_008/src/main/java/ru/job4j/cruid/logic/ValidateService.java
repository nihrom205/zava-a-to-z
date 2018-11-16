package ru.job4j.cruid.logic;

import ru.job4j.cruid.dao.Role;
import ru.job4j.cruid.dao.User;
<<<<<<< HEAD
import ru.job4j.cruid.persistent.MemoryStore;
=======
import ru.job4j.cruid.persistent.DBStore;
import ru.job4j.cruid.persistent.Store;
>>>>>>> origin/filter

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
<<<<<<< HEAD
    public void add(String name, String email) {
        if (name.equals("") || MemoryStore.getInstance().findAll().contains(new User(0, name, email))) {
            return;
        }
        MemoryStore.getInstance().add(new User(id++, name, email));
    }

    public void update(int id, String name, String email) {
        MemoryStore.getInstance().update(new User(id, name, email));
    }

    public void delete(int id) {
        MemoryStore.getInstance().delete(id);
=======
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
>>>>>>> origin/filter
    }

    public List<User> findAll() {
        return MemoryStore.getInstance().findAll();
    }

<<<<<<< HEAD
    public User findById(int id) {
        return MemoryStore.getInstance().findById(id);
=======
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
>>>>>>> origin/filter
    }
}
