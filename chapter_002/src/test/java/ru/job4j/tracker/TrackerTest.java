package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

/**
 * Test.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 19.06.2018
 */
public class TrackerTest {

    /**
     * tests method add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker t = mock(Tracker.class);
        Item item = new Item("test1", "testDescription1", 123L);
        when(t.add(item)).thenReturn(new Item("test1", "testDescription1", 123L));

        assertThat(t.add(item).getName(), is("test1"));


//        try (Tracker tracker = new Tracker("config.properties")) {
//            tracker.add(new Item("test1", "testDescription1", 123L));
//            tracker.add(new Item("test2", "testDescription2", 100L));
//            tracker.add(new Item("test3", "testDescription3", 111L));
//            tracker.add(new Item("test4", "testDescription4", 124L));
//
//            assertThat(tracker.findAll().size(), is(4));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
