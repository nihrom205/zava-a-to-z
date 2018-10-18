package ru.job4j.cruid.persistent;

import ru.job4j.cruid.dao.Role;
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
    public User add(User user) {
        storeUsers.put(user.getId(), user);
        return user;
    }

    @Override
    public void update(User user) {
        add(user);

    }

    @Override
    public void delete(User user) {
        storeUsers.remove(user.getId());

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
    public User findById(User user) {
        return storeUsers.get(user.getId());
    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public List<Role> findAllRoles() {
        return null;
    }

    @Override
    public User findByLogin(User user) {
        return null;
    }

    @Override
    public void delRole(Role role) {

    }
}
