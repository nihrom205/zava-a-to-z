package ru.job4j.threads;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class FoundWordSpaceTest.
 * Тестирование класса FoundWordSpace.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 22.01.2018
 */
public class FoundWordSpaceTest {
    @Test
    public void whenFindWordAndSpaceThenCountWordAndSpace() {
        FoundWordSpace found = new FoundWordSpace("AZaza vv dd");
        found.runFind();
        try {
            Thread.sleep(1000);
            assertThat(found.getCountWord(), is(3));
            assertThat(found.getCountSpace(), is(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}