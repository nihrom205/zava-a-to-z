package ru.job4j.deviceAutomate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Описание.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 10.11.2017
 */
public class AutomateTest {
    @Test
    public void whenAutomatMoneyThenSurrenderMoneyOut() {
        Automate automate = new Automate();
        int[] rezult = automate.changes(103, 35);
        assertThat(rezult, is(new int[]{10, 10, 10, 10, 10, 10, 5, 2, 1}));
    }
}
