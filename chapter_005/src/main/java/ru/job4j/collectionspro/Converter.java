package ru.job4j.collectionspro;

import java.util.Iterator;

/**
 * Class Converter.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.11.2017
 */
public class Converter {
    private Iterator<Iterator<Integer>> iter = null;
    private Iterator<Integer> currentIter = null;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.iter = it;
        this.currentIter = it.next();
        return new Iterator<Integer>() {

            private void checked() {
                if (!iter.hasNext()) {
                    currentIter = it.next();
                }
            }

            @Override
            public boolean hasNext() {
//                boolean isHasNext = false;
//                if (it.hasNext()) {
//                    Iterator iter = it.next();
//                    isHasNext = iter.hasNext();
//                }
//                return isHasNext;
                return false;
            }

            @Override
            public Integer next() {
                if (it.hasNext())
                while (true) {
                    Iterator iterator = it.next();
                    while (iterator.hasNext()) {
                        return (Integer) iterator.next();
                    }
                }
                return null;
            }
        };
    }
}
