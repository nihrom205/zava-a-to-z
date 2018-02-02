package ru.job4j.sync;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 02.02.2018
 */
public class CountTest {

    private class ThreadCount extends Thread {
        private final Count count;

        private ThreadCount(final Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            this.count.increment();
        }
    }

    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        final Count count = new Count();

        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);

        first.start();
        second.start();

        first.join();
        second.join();

        assertThat(count.getValue(), is(2));
    }

}