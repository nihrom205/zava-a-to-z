package ru.job4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 29.12.2018
 */
@Component
public class UserStorage {
    private final Storage storage;

    @Autowired
    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        storage.add(user);
    }

    public void delete(User user) {
        storage.delete(user);
    }

    public List<User> getAll() {
        return storage.getAll();
    }

    public void update(User user) {
        storage.update(user);
    }
}
