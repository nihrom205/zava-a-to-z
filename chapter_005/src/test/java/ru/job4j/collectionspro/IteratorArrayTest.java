package ru.job4j.collectionspro;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 19.11.2017
 */
public class IteratorArrayTest {

    @Test
    public void whenNextCallThenForward() {
//        IteratorArray it = new IteratorArray(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        IteratorArray it = new IteratorArray(new int[][] {{1}, {3}, {5}, {7}});

        it.next();
        it.next();
        int rezult = it.next();

        assertThat(rezult, is(5));
    }

    @Test
    public void whenCheckNextPositionThenValue() {
        IteratorArray it = new IteratorArray(new int[][] {{1, 2}});

        boolean rezult = it.hasNext();

        assertThat(rezult, is(true));
    }

}