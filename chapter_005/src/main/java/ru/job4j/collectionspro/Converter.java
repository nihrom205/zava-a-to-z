package ru.job4j.collectionspro;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter.
 * конвертирует Iterator<Iterator<Integer>>   ->   Iterator<Integer>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.11.2017
 */
public class Converter {
    private Iterator<Iterator<Integer>> iter = null;
    private Iterator<Integer> currentIter = null;

    /**
     * метод принимает Iterator<Iterator<Integer>> и преобразует в Iterator<Integer>.
     * @param it Iterator<Iterator<Integer>>
     * @return Iterator<Integer>
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.iter = it;
        this.currentIter = it.next();
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                boolean isHasNext = false;
                if (currentIter.hasNext()) {
                    isHasNext = true;
                }
                if (!currentIter.hasNext() && iter.hasNext()) {
                    isHasNext = true;
                }
                return isHasNext;
            }

            @Override
            public Integer next() {
                Integer value = null;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (!currentIter.hasNext()) {
                    currentIter = iter.next();
                }
                value = currentIter.next();
                return value;
            }
        };
    }
}
