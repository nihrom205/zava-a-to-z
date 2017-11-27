package ru.job4j.collectionspro;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        return (checked(true) != null) ? true : false;
    }

    @Override
    public Integer next() {
        return checked(false);
    }

    private Integer checked(boolean isHasNext) {
        Integer value = null;
        int col = indexColumn;
        int row = indexRow;
        if (col < mass[row].length) {
            value = mass[row][col++];
        } else if ((row += 1) < mass.length){
            col = 0;
            value = mass[row][col++];
        } else if (!isHasNext){
            throw new NoSuchElementException();
        }
        if (!isHasNext) {
            indexColumn = col;
            indexRow = row;
        }
        return value;
    }
}
