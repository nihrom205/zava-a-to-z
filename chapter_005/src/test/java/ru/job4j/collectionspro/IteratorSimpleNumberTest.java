package ru.job4j.collectionspro;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Class IteratorSimpleNumber.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.11.2017
 */
public class IteratorSimpleNumberTest {
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new IteratorSimpleNumber(new int[]{4, 4, 5, 8, 11, 14});
    }

    @Test
    public void whenArrayNumberThenSimpleNumber() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(false));
    }

}