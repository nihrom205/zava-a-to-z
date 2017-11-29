package ru.job4j.collectionspro;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Описание клас возвращает из массива только простые числа.
 * Простым является натуральное число больше 1, которое делится без остатка только на 1 и на себя.
 *
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.11.2017
 */
public class IteratorSimpleNumber implements Iterator {
    private final int[] mass;
    private int index = 0;

    public IteratorSimpleNumber(int[] mass) {
        this.mass = mass;
    }

    @Override
    public boolean hasNext() {

        return this.simpleNumber(true) != 0 ? true : false;
    }

    @Override
    public Object next() {
        int rezult = 0;
        rezult = this.simpleNumber(false);
        if (rezult == 0) {
            throw new NoSuchElementException();
        }
        return rezult;
    }

    private int simpleNumber(boolean isHashNext) {
        int rezult = 0;
        for (int i = index; i < mass.length; i++) {
            boolean isSimple = true;
            if (mass[i] == 1 || mass[i] == 2) {
                rezult = mass[i];
            } else {
                for (int j = 2; j < mass[i]; j++) {
                    if (mass[i] % j == 0) {
                        isSimple = false;
                        break;
                    }
                }
            }
            if (isSimple && !isHashNext) {
                rezult = mass[i++];
                index = i;
                break;
            } else if (isSimple && isHashNext) {
                rezult = mass[i];
                break;
            }
        }
        return rezult;
    }
}
