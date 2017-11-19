package ru.job4j.collectionspro;

import java.util.Iterator;

/**
 * Class возвращает только четные числа.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.11.2017
 */
public class IteratorArrayEven implements Iterator {
    private final int[] array;
    private int index = 0;

    public IteratorArrayEven(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    @Override
    public Integer next() {
        int rezult = 0;
        while (hasNext()) {
            if (array[index] % 2 == 0) {
                rezult = array[index++];
                break;
            }
            index++;
        }
        return rezult;
    }
}
