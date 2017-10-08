package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MergerTwoArray.
 */
public class MergerTwoArrayTest {

    /**
     * Метод тестирует слияние отсортированных массивов.
     */
    @Test
    public void whereMergeTwoArraysOrderThereOneArrayOrder() {
        MergerTwoArray mergerTwoArray = new MergerTwoArray();
        int[] oneArray = {2, 4, 6, 8, 10, 12};
        int[] twoArray = {1, 3, 5, 7, 9, 11};
        int[] result = mergerTwoArray.merge(oneArray, twoArray);
        int[] expection = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        assertThat(result, is(expection));
    }
}
