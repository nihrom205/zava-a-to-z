package ru.job4j.threads;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 26.01.2018
 */
public class StopThredTest {

    @Test
    public void whenTwoThreadThenCountText() {
        StopThred stopThred = new StopThred("aa bb cc", 5);
    }
}