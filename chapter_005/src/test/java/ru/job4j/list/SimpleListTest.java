package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Class Testing SimpleLinkedList.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 15.12.2017
 */
public class SimpleListTest {
    @Test
    public void whenAddListThenElementsList() {
        SimpleList<String> mass = new SimpleList<>();
        mass.add("aaa");
        mass.add("bbb");
        mass.add("ccc");

        assertThat(mass.get(1), is("bbb"));

    }

    @Test (expected = NoSuchElementException.class)
    public void whenIteratorThenElementsList() {
        SimpleList<String> mass = new SimpleList<>();
        mass.add("one");
        mass.add("two");
        mass.add("tree");

        Iterator<String> iter = mass.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is("one"));
        assertThat(iter.next(), is("two"));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is("tree"));
        assertThat(iter.hasNext(), is(false));
        assertThat(iter.next(), is("tree"));

    }
}