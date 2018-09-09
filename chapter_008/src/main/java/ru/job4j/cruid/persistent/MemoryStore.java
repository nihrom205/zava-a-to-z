package ru.job4j.cruid.persistent;

import ru.job4j.cruid.dao.User;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class для оаботы с бд.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 30.08.18
 */
public class MemoryStore implements Store<User> {
    private static final MemoryStore STORE = new MemoryStore();
    private final ConcurrentHashMap<Integer, User> storeUsers = new ConcurrentHashMap();

    private MemoryStore() {

    }

    public static MemoryStore getInstance() {
        return STORE;
    }

    @Override
    public void add(User user) {
        storeUsers.put(user.getId(), user);
    }

    @Override
    public void update(User user) {
        add(user);

    }

    @Override
    public void delete(int id) {
        storeUsers.remove(id);

    }

    @Override
    public List<User> findAll() {
        List<User> list = new LinkedList<>();
        for (User value : storeUsers.values()) {
            list.add(value);
        }
        return list;
    }

    @Override
    public User findById(int id) {
        return storeUsers.get(id);
    }
}
