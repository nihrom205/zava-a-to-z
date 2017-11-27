package ru.job4j.collectionspro;

import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 19.11.2017
 */
public class IteratorArrayTest {
    private IteratorArray it;

    @Before
    public void setUp() {
//        IteratorArray it = new IteratorArray(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}});
//        IteratorArray it = new IteratorArray(new int[][] {{1}, {3}, {5}, {7}});
        it = new IteratorArray(new int[][] {{1, 2, 3}, {7}});
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNextCallThenForward() {
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
        assertThat(it.next(), is(10));
    }

    @Test
    public void whenCheckNextPositionThenValue() {
        IteratorArray it = new IteratorArray(new int[][] {{1, 2}});

        boolean rezult = it.hasNext();

        assertThat(rezult, is(true));
    }

}