package ru.job4j;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 29.12.2018
 */
@Component
public class MemoryStorage implements Storage {
    private final List<User> store = new ArrayList<>();

    @Override
    public void add(User user) {
        store.add(user);
    }

    @Override
    public void update(User user) {
        int index = -1;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getId().equals(user.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            store.add(index, user);
        }
    }

    @Override
    public void delete(User user) {
        store.remove(user);
    }

    @Override
    public List<User> getAll() {
        return store;
    }
}
