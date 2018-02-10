package ru.job4j.wait;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 10.02.2018
 */
public class WorkQueueTest {
    @Test
    public void whenAddWorkThenPrintWorkThreads() throws InterruptedException {
        WorkQueue work = new WorkQueue();

        work.run();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10000000; j++) {
                work.add(new Work("stream-" + i + " work-" + j));
            }
            Thread.sleep(3000);

        }
    }

}