package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class тестирует SimpleLinkedListSet.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 18.12.17
 */
public class SimpleLinkedListSetTest {

    @Test (expected = NoSuchElementException.class)
    public void whenAddStringElementsThenAddedElements() {
        SimpleLinkedListSet<String> arr = new SimpleLinkedListSet<>();
        arr.add("one");
        arr.add("two");
        arr.add("tree");
        arr.add("two");

        Iterator<String> iter = arr.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is("one"));
        assertThat(iter.next(), is("two"));
        assertThat(iter.next(), is("tree"));
        assertThat(iter.hasNext(), is(false));
        assertThat(iter.next(), is("tree"));
    }

}