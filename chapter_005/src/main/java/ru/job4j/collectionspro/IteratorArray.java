package ru.job4j.collectionspro;

import java.util.Iterator;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 19.11.2017
 */
public class IteratorArray implements Iterator {
    private final int[][] mass;
    private int sizeMass;
    private int indexColumn = 0;    // колонки
    private int indexRow = 0;       // строки

    public IteratorArray(final int[][] mass) {
        this.mass = mass;
        sizeMass = mass.length * mass[0].length;
    }

    @Override
    public boolean hasNext() {
        return sizeMass > indexColumn * indexRow;
    }

    @Override
    public Integer next() {
        Integer value = 0;
        if (indexColumn < mass[indexRow].length) {
            value = mass[indexRow][indexColumn++];
        } else {
            indexRow++;
            indexColumn = 0;
            value = mass[indexRow][indexColumn++];
        }
        return value;
    }
}
