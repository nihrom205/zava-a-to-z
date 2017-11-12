package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Class Tracker.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 19.10.2017
 */
public class Tracker {
    /**
     * переменная для хранения всех заявок.
     */
//    private Item[] items = new Item[100];
    private List<Item> items = new ArrayList<>();
    /**
     * переменная текущей свободной позиции в массиве.
     */
    private int position = 0;
    /**
     *
     */
    private static final Random RN = new Random();

    /**
     * метод для добавление заявки в массив.
     * @param item заяка
     * @return заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * обновляет заявку.
     * @param item заявка
     */
    public void update(Item item) {
        for (int i = 0; i < position; i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(item.getId())) {
                this.items.add(item);
                break;
            }
        }
    }

    /**
     * удаляет заявку.
     * @param item заявка
     */
    public void delete(Item item) {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item value = it.next();
            if (value != null && value.getId().equals(item.getId())) {
                it.remove();
                break;
            }
        }
    }

    /**
     * возвращает все заявки все заявки.
     * @return массив заявок
     */
    public List<Item> findAll() {
//        Item[] itemArray = new Item[position];
//        System.arraycopy(this.items, 0, itemArray, 0, position);
        return this.items;
    }

    /**
     * ищет заявку по наименованию.
     * @param key наименование заявки
     * @return массив заявок
     */
    public List<Item> findByName(String key) {
        List<Item> arrayName = new ArrayList<>();
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                arrayName.add(item);
            }
        }
        return arrayName;
    }

    /**
     * ищет заявку по id.
     * @param id id
     * @return заявку
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * генератор id.
     * @return id
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
