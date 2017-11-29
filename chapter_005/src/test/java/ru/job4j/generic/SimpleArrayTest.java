package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 29.11.2017
 */
public class SimpleArrayTest {

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenAddIntegerArrayThenArrayValues() {
        SimpleArray<Integer> sa = new SimpleArray<>(4);
        sa.add(4);
        sa.add(7);
        sa.add(6);
        assertThat(sa.get(0), is(4));
        assertThat(sa.get(2), is(6));
        assertThat(sa.get(4), is(0));

    }

    @Test
    public void whenUpdateArrayElementsIntegerThenArray() {
        SimpleArray<Integer> sa = new SimpleArray<>(4);
        sa.add(4);
        sa.add(7);
        sa.add(6);
        sa.add(10);
        assertThat(sa.update(7, 99), is(true));
    }

    @Test
    public void whenUpdateArrayElementsStringThenArray() {
        SimpleArray<String> sa = new SimpleArray<>(4);
        sa.add("a");
        sa.add("b");
        sa.add("c");
        sa.add("d");
        assertThat(sa.update("c", "ff"), is(true));
    }

    @Test
    public void whenDeleteArrayElementsStringThenArray() {
        SimpleArray<String> sa = new SimpleArray<>(4);
        sa.add("a");
        sa.add("b");
        sa.add("c");
        sa.add("d");
        assertThat(sa.delete("b"), is(true));
    }

    @Test
    public void whenDeleteArrayElementsIntegerThenArray() {
        SimpleArray<Integer> sa = new SimpleArray<>(4);
        sa.add(6);
        sa.add(2);
        sa.add(4);
        sa.add(8);
        assertThat(sa.delete(8), is(true));
    }


}