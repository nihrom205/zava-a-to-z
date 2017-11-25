package ru.job4j.collectionspro;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class тестирование итератора возвращает только четные числа.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.11.2017
 */
public class IteratorArrayEvenTest {
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new IteratorArrayEven(new int[]{1, 2, 3, 5, 4, 8, 9, 3});
    }

    @Test
    public void whenNextNumberArrayThenForward() {
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenNextEvenNumberArrayThenReturnTrue() {
        it.next();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}
