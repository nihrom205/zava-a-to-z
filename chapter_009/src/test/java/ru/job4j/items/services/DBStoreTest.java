package ru.job4j.items.services;

import org.junit.Test;
import ru.job4j.items.models.Item;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 31.12.2018
 */
public class DBStoreTest {

    @Test
    public void whenInstanceDBSTORE() {
        DBStoreImpl dbStore = DBStore.getInstance();
        assertNotNull(dbStore);
//        dbStore.addItem(new Item());
    }

    @Test
    public void whenTwoObjectExuals() {
        DBStoreImpl dbStore1 = DBStore.getInstance();
        DBStoreImpl dbStore2 = DBStore.getInstance();
        assertThat(dbStore1, is(dbStore2));
        assertTrue(dbStore1 == dbStore2);
    }

    @Test
    public void whenAddItemThenOneItem() {
        DBStore dbStore = DBStore.getInstance();
        dbStore.addItem(new Item("new item", new Timestamp(new Date().getTime()), true));
        List<Item> list = dbStore.getAllItems();
        System.out.println(list.size());
    }


}