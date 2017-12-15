package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class SimpleStackTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 15.12.2017
 */
public class SimpleStackTest {

    /**
     * тест проверяет добавление и удаление элементов.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenAddElementsStackThenSimpleStackAdding() {
        SimpleStack<String> mass = new SimpleStack<>();
        mass.push("one");
        mass.push("two");
        mass.push("tree");

        assertThat(mass.poll(), is("tree"));
        assertThat(mass.poll(), is("two"));
        assertThat(mass.poll(), is("one"));
        assertThat(mass.poll(), is("bad"));
    }

    /**
     * тест проверяет обход итератора.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenIterThenElement() {
        SimpleStack<String> mass = new SimpleStack<>();
        mass.push("aaa");
        mass.push("bbb");
        mass.push("ccc");

        Iterator<String> iter = mass.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is("ccc"));
        assertThat(iter.next(), is("bbb"));
        assertThat(iter.next(), is("aaa"));
        assertThat(iter.hasNext(), is(false));
        assertThat(iter.next(), is("bad"));
    }

}