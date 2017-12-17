package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class SimpleSetTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 17.12.2017
 */
public class SimpleSetTest {

    @Test (expected = NoSuchElementException.class)
    public void whenAddElementsSimpleSetThenAdditingElements() {
        SimpleSet<String> mass = new SimpleSet<>(5);

        mass.add("one");
        mass.add("two");
        mass.add("tree");

        Iterator<String> iter = mass.iterator();

        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is("one"));
        assertThat(iter.next(), is("two"));
        assertThat(iter.next(), is("tree"));
        assertThat(iter.hasNext(), is(false));
        assertThat(iter.next(), is("bad"));

    }

    @Test
    public void whenAddElementMaxThenCreateTwoSuze() {
        SimpleSet<String> arr = new SimpleSet<>(3);

        arr.add("one");
        arr.add("two");
        arr.add("tree");
        arr.add("four");
        arr.add("five");
        arr.add("sixe");

        Iterator<String> iter = arr.iterator();

        assertThat(iter.next(), is("one"));
        assertThat(iter.next(), is("two"));
        assertThat(iter.next(), is("tree"));
        assertThat(iter.next(), is("four"));
        assertThat(iter.next(), is("five"));
        assertThat(iter.next(), is("sixe"));
        assertThat(iter.hasNext(), is(false));

    }
}