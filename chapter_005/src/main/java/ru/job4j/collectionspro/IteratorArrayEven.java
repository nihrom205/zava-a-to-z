package ru.job4j.collectionspro;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        int indexArray = this.index;
        boolean isEven = false;
        for (int i = index; i < array.length; i++) {
            if (this.isEven(indexArray++)) {
                isEven = true;
                break;
            }
        }
        return isEven;
    }

    @Override
    public Integer next() {
        int rezult = -1;
        while (hasNext()) {
            if (this.isEven(index)) {
                rezult = array[index++];
                break;
            }
            index++;
        }
        if (rezult == -1) {
            throw new NoSuchElementException();
        }
        return rezult;
    }

    /**
     * мето проверяет четное число или нет.
     * @param index позиция в массиве
     * @return true and false
     */
    private boolean isEven(int index) {
        return array[index] % 2 == 0;
    }
}
