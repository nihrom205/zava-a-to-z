package ru.job4j.phone;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class хранения и поиска.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.09.18
 */
public class PhoneDictonary {
    private List<Persone> storage = new ArrayList<>();

    /**
     * Добавление в хранилище Пользователя.
     * @param persone пользователь
     */
    public void add(Persone persone) {
        this.storage.add(persone);
    }

    /**
     * Поиск в хранилеще по ключу.
     * @param key ключь для поиска
     * @return список пользователей
     */
    public List<Persone> find(String key) {
        return storage.stream().filter(person -> person.getName().contains(key) || person.getSurname().contains(key) || person.getPhone().contains(key) || person.getAddress().contains(key))
                .collect(Collectors.toList());
    }
}
