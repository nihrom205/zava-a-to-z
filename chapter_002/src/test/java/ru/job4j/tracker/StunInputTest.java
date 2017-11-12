package ru.job4j.tracker;

import org.junit.Test;
import java.util.Calendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class StunInputTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 22.10.17
 */
public class StunInputTest {
    /**
     * testing method add.
     */
    @Test
    public void whenUserAddNewItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    /**
     * testing method show.
     */
    @Test
    public void whenUserShowAllItemsThenTrackerShowAllItems() {
        Tracker tracker = new Tracker();
        long date = Calendar.getInstance().getTimeInMillis();
        Item itemOne = new Item("Error sql", "Error mysql", date);
        Item itemTwo = new Item("Error page", "Error apache, page 4. number error 404", date);
        Item itemThree = new Item("Update Windows 7", "Update os.", date);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        Item[] items = new Item[3];
        items[0] = itemOne;
        items[1] = itemTwo;
        items[2] = itemThree;
        new StubInput(new String[] {"1", "6"});
        assertThat(tracker.findAll(), is(items));
    }

    /**
     * testing method update (edit).
     */
    @Test
    public void whenUserEditItemsThenTrackerEditingItems() {
        Tracker tracker = new Tracker();
        long date = Calendar.getInstance().getTimeInMillis();
        Item item = new Item("Error page", "Error apache, page 4. number error 404", date);
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    /**
     * testing metgod delete.
     */
    @Test
    public void whenUserDeleteItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        long date = Calendar.getInstance().getTimeInMillis();
        Item itemOne = new Item("Error sql", "Error mysql", date);
        Item itemTwo = new Item("Error page", "Error apache, page 4. number error 404", date);
        Item itemThree = new Item("Update Windows 7", "Update os.", date);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        Item[] items = new Item[2];
        items[0] = itemOne;
        items[1] = itemThree;
        Input input = new StubInput(new String[]{"3", itemTwo.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(items));
    }

    /**
     * testing find by id.
     */
    @Test
    public void whenUserFindByIdItemThenTrackerFoundIdisItems() {
        Tracker tracker = new Tracker();
        long date = Calendar.getInstance().getTimeInMillis();
        Item itemOne = new Item("Error sql", "Error mysql", date);
        Item itemTwo = new Item("Error page", "Error apache, page 4. number error 404", date);
        Item itemThree = new Item("Update Windows 7", "Update os.", date);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        Input input = new StubInput(new String[]{"4", itemTwo.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(itemTwo.getId()).getName(), is("Error page"));
    }

    /**
     * testing find by name.
     */
    @Test
    public void whenUserFindByNameItemThenTrackerFoundNameisItems() {
        Tracker tracker = new Tracker();
        long date = Calendar.getInstance().getTimeInMillis();
        Item itemOne = new Item("Error sql", "Error mysql", date);
        Item itemTwo = new Item("Error page", "Error apache, page 4. number error 404", date);
        Item itemThree = new Item("Update Windows 7", "Update os.", date);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        Item[] items = new Item[1];
        items[0] = itemThree;
        Input input = new StubInput(new String[]{"5", itemThree.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(itemThree.getName()), is(items));
    }
}
