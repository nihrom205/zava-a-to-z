package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ArrayDuplicateTest.
 */
public class ArrayDuplicateTest {
    /**
     * метод тестирует класс ArrayDuplicate.
     */
    @Test
    public void whenArraStringThenRemoveArrayDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] extend = {"Привет", "Мир", "Супер"};
        String[] result = arrayDuplicate.remove(array);
        assertThat(result, is(extend));
    }
}
