package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FindStr.
 */
public class FindStrTest {

    /**
     * Test FindStr classes.
     */
    @Test
    public void whereFindStringToString() {
        FindStr fStr = new FindStr();
        String origin = "Привет";
        String sub = "иве";
        boolean result = fStr.contains(origin, sub);
        assertThat(result, is(true));
    }
}
