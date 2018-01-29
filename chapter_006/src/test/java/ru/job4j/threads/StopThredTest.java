package ru.job4j.threads;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
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
    public void whenTwoThreadThenCountText() throws InterruptedException {
        StopThred stopThred = new StopThred("aa bb cc  ffafa ddd ddds fsfsdf dsf sf df s sdfs df df sdf  sdf sdfsd fsdf sdf sd s  sdfds fsdf  dfsd dsfk sdfkdskfsdfsdhfsdh fsdjfjsd", 1);
        stopThred.start();
        stopThred.getT1().join();
        assertThat(stopThred.getCountWord(), is(27));
    }
}