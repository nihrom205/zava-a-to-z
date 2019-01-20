package ru.job4j.items.services;

import ru.job4j.items.models.Item;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.12.2018
 */
public interface DBStoreImpl {
    void addItem(Item item);
    List<Item> getAllItems();
}
