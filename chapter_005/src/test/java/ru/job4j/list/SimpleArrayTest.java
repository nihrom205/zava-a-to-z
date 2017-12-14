package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Class SimpleArrayTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 13.12.2017
 */
public class SimpleArrayTest {

    @Test
    public void whenAddElementsThenAdditingSimpleArray() {
        SimpleArray<Integer> array = new SimpleArray<>();
        array.add(10);
        array.add(13);
        array.add(15);
        assertThat(array.get(1), is(13));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenHashNextSimpleArrayThenNextElement() {
        SimpleArray<Integer> array = new SimpleArray<>();
        array.add(40);
        array.add(45);
        array.add(70);

        Iterator<Integer> iter = array.iterator();
        assertThat(iter.next(), is(40));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(45));
        assertThat(iter.next(), is(70));
        assertThat(iter.hasNext(), is(false));
        assertThat(iter.next(), is(70));
    }

    @Test
    public void whenAddStringsElementThenAdditingSimpleArray() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("one");
        array.add("two");
        array.add("tree");
        assertThat(array.get(1), is("two"));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenHashNextStringSimpleArrayThenNextElement() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("one");
        array.add("two");
        array.add("tree");

        Iterator<String> iter = array.iterator();
        assertThat(iter.next(), is("one"));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is("two"));
        assertThat(iter.next(), is("tree"));
        assertThat(iter.hasNext(), is(false));
        assertThat(iter.next(), is("1111"));
    }

    @Test
    public void whenAddElementsMaxThenAdditingSimpleArray() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(10);
        array.add(13);
        array.add(15);
        array.add(100);
        array.add(200);
        assertThat(array.get(1), is(13));
        assertThat(array.get(4), is(200));
    }

}