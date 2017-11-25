package ru.job4j.collectionspro;

import java.util.Iterator;

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
        return mass.length > index;
    }

    @Override
    public Object next() {
        int rezult = 0;
        int endIndex = (int) Math.sqrt(mass[index]);
        if (mass[index] == 1 || mass[index] == 2) {
            rezult = mass[index++];
        } else {
            for (int i = 2; i < endIndex; i++) {
                if (mass[index] % i == 0) {
                    rezult = mass[index++];
                }
            }
        }
        return null;
    }
}
