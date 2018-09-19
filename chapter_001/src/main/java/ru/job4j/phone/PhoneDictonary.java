package ru.job4j.phone;

import java.util.ArrayList;
import java.util.List;

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
        List<Persone> result = new ArrayList<>();
        for (Persone persone : this.storage) {
            if (persone.getName().contains(key) || persone.getSurname().contains(key) || persone.getAddress().contains(key) || persone.getPhone().contains(key)) {
                result.add(persone);
            }
        }
        return result;
    }
}
