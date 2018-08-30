package ru.job4j.cruid.persistent;

import org.apache.log4j.Logger;
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
public class MemoryStore implements Store {
    private static final Logger logger = Logger.getLogger(MemoryStore.class);
    private static final MemoryStore memoryStore = new MemoryStore();
    private final ConcurrentHashMap<Integer, User> store = new ConcurrentHashMap();

    private MemoryStore() {

    }

    public static MemoryStore getInstance() {
        return memoryStore;
    }

    @Override
    public void add(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public void update(User user) {
        add(user);

    }

    @Override
    public void delete(int id) {
        store.remove(id);

    }

    @Override
    public List<User> findAll() {
        List<User> list = new LinkedList<>();
        for (User value : store.values()) {
            list.add(value);
        }
        return list;
    }

    @Override
    public User findById(int id) {
        return store.get(id);
    }
}
