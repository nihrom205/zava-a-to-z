package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class SimpleQueueTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 15.12.2017
 */
public class SimpleQueueTest {

    /**
     * тест проверяет добавление и возврат елементов из колекции.
     */
    @Test
    public void whenAddElementQueueThenAddingElements() {
        SimpleQueue<String> mass = new SimpleQueue<>();
        mass.push("one");
        mass.push("two");
        mass.push("tree");

        assertThat(mass.poll(), is("tree"));
        assertThat(mass.poll(), is("two"));
        assertThat(mass.poll(), is("one"));
    }

    /**
     * тест для проверки итератора.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenIterThenElement() {
        SimpleStack<Integer> array = new SimpleStack<>();
        array.push(1);
        array.push(2);
        array.push(3);

        Iterator<Integer> iter = array.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(false));
        assertThat(iter.next(), is(000));
    }

}