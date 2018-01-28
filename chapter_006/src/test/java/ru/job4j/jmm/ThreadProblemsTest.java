package ru.job4j.jmm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class ThreadProblemsTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.01.2018
 */
public class ThreadProblemsTest {
    @Test
    public void whenVisibleOfSharingThenResult() {
        new ThreadProblems();
    }
}