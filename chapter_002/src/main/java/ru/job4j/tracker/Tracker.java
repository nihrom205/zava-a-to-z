package ru.job4j.tracker;

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
    private Item[] items = new Item[100];
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
        this.items[position++] = item;
        return item;
    }

    /**
     * обновляет заявку.
     * @param item заявка
     */
    public void update(Item item) {
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * удаляет заявку.
     * @param item заявка
     */
    public void delete(Item item) {
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                System.arraycopy(this.items, i + 1, this.items, i, position - i - 1);
                this.position--;
                this.items[position] = null;
                break;
            }
        }
    }

    /**
     * возвращает все заявки все заявки.
     * @return массив заявок
     */
    public Item[] findAll() {
        Item[] itemArray = new Item[position];
        System.arraycopy(this.items, 0, itemArray, 0, position);
        return itemArray;
    }

    /**
     * ищет заявку по наименованию.
     * @param key наименование заявки
     * @return массив заявок
     */
    public Item[] findByName(String key) {
        Item[] arrayName = new Item[position];

        int index = 0;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                arrayName[index++] = items[i];
            }
        }
        Item[] result = new Item[index];
        System.arraycopy(arrayName,0,result,0, index);
        return result;
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

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
