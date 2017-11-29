package ru.job4j.collectionspro;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class IteratorArray.
 * класс позволяет пробегать по массиву и получать элементы из одномерного/двумерного массивов.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 19.11.2017
 */
public class IteratorArray implements Iterator {
    private final int[][] mass;
    private int indexColumn = 0;    // колонки
    private int indexRow = 0;       // строки

    public IteratorArray(final int[][] mass) {
        this.mass = mass;
    }

    @Override
    public boolean hasNext() {
        return (checked(true) != null);
    }

    @Override
    public Integer next() {
        return checked(false);
    }

    /**
     * метод проверяет есть ли в массиве элементы, если есть то возвращает элемент иначе возвращает null.
     * @param isHasNext true если метод вызвал hasNext, false если next
     * @return значение или null
     */
    private Integer checked(boolean isHasNext) {
        Integer value = null;
        int col = indexColumn;
        int row = indexRow;
        if (col < mass[row].length) {
            value = mass[row][col++];
        } else if ((++row) < mass.length) {
            col = 0;
            value = mass[row][col++];
        } else if (!isHasNext) {
            throw new NoSuchElementException();
        }
        if (!isHasNext) {
            indexColumn = col;
            indexRow = row;
        }
        return value;
    }
}
