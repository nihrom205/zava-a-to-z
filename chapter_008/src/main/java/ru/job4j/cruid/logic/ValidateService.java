package ru.job4j.cruid.logic;

import ru.job4j.cruid.dao.User;
import ru.job4j.cruid.persistent.MemoryStore;

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
    private int id = 0;

    private ValidateService() {
    }

    public static ValidateService getInstance() {
        return service;
    }

    /**
     * Метод добавляет
     * @param name
     */
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
    }

    public List<User> findAll() {
        return MemoryStore.getInstance().findAll();
    }

    public User findById(int id) {
        return MemoryStore.getInstance().findById(id);
    }
}
