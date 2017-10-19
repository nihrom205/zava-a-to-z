package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $Id$
 * @since 19.10.2017
 */
public class TrackerTest {
    /**
     * tests method add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem(){
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * test method delete.
     */
    @Test
    public void whenArrayDeleteOneItemThenTrackerArrayItem() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1", "testDescription", 123L);
        Item itemTwo = new Item("test2", "testDescription", 123L);
        Item itemTree = new Item("test3", "testDescription", 123L);
        Item itemFour = new Item("test4", "testDescription", 123L);
        Item itemFive = new Item("test5", "testDescription", 123L);
        Item itemSex = new Item("test6", "testDescription", 123L);

        Item[] arrayItem = new Item[5];
        arrayItem[0] = itemOne;
        arrayItem[1] = itemTwo;
        arrayItem[2] = itemTree;
        arrayItem[3] = itemFive;
        arrayItem[4] = itemSex;

        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemTree);
        tracker.add(itemFour);
        tracker.add(itemFive);
        tracker.add(itemSex);

        tracker.delete(itemFour);

        assertThat(tracker.findAll(), is(arrayItem));
    }

    /**
     * tests method update.
     */
    @Test
    public void whenUpdatetemThenTrackerUpdatingItem(){
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1", "testDescription", 123L));
        tracker.add(new Item("test2", "testDescription", 123L));
        tracker.add(new Item("test3", "testDescription", 123L));

        Item item = tracker.findAll()[1];
        item.setName("XXXXX");
        item.setDesc("YYYYYYYYYY");
        item.setCreated(444L);
        assertThat(tracker.findAll()[1], is(item));
    }

    /**
     * tests method findAll.
     */
    @Test
    public void whenFindAllThenTrackerGetItems(){
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1", "testDescription", 123L);
        Item itemTwo = new Item("test2", "testDescription", 123L);
        Item itemTree = new Item("test3", "testDescription", 123L);

        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemTree);

        Item[] arrayItem = new Item[3];
        arrayItem[0] = itemOne;
        arrayItem[1] = itemTwo;
        arrayItem[2] = itemTree;

        assertThat(tracker.findAll(), is(arrayItem));
    }

    /**
     * tests method findByName.
     */
    @Test
    public void whenFindByNameThenTrackerNameItems(){
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1", "testDescription", 123L);
        Item itemTwo = new Item("test2", "testDescription2222", 123L);
        Item itemTree = new Item("test3", "testDescription", 123L);
        Item itemFour = new Item("test2", "testDescription00", 123L);

        Item[] result = new Item[2];
        result[0] = itemTwo;
        result[1] = itemFour;
        //---------------------------

        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemTree);
        tracker.add(itemFour);

        Item[] arrayItem = tracker.findByName("test2");

        assertThat(arrayItem, is(result));
    }

    /**
     * tests method findById.
     */
    @Test
    public void whenFindByIdThenTrackerIdItem(){
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1", "testDescription", 123L);
        Item itemTwo = new Item("test2", "testDescription", 123L);
        Item itemTree = new Item("test3", "testDescription", 123L);
        Item itemFour = new Item("test4", "testDescription00", 123L);

        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemTree);
        tracker.add(itemFour);

        String id = tracker.findAll()[3].getId();
        Item result = tracker.findById(id);
        assertThat(tracker.findAll()[3], is(result));

//        String id = "11";
//        assertThat(null, is(result));         // проверка null
    }
}
