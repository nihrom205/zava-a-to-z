package ru.job4j.threads;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 29.01.2018
 */
public class FoundToTextTest {
    @Test
    public void whenFindWordAndSpaceThreadThenPrint() throws InterruptedException {
        Runnable runnable1 = new FoundToText("aa bb cc");
        Thread t1 = new Thread(runnable1);

        Runnable runnable2 = new FoundToText("aa bb cc dddd eeeeeee");
        Thread  t2 = new Thread(runnable2);

        t1.start();
        t2.start();

        Thread.sleep(1000);
        assertThat(((FoundToText) runnable1).getCountWord(), is(3));
    }

}