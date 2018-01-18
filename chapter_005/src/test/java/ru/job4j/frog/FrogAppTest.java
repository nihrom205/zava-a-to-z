package ru.job4j.frog;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class FrogAppTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 18.01.2018
 */
public class FrogAppTest {

    @Test
    public void whenAddStartAndEndThenPath() {
        int[] arg = {7, 11, 10, 9, 2, 9, 14, 8, 5};
        FrogApp frog = new FrogApp(arg);
        frog.run();
    }

}