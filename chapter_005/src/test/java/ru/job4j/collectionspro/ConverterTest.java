package ru.job4j.collectionspro;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Class ConverterTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.11.2017
 */
public class ConverterTest {

    @Test
    public void whenIteratorNextWhenNumber() {
        Iterator<Integer> i1 = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
        Iterator<Integer> i2 = Arrays.asList(0, 9, 8, 7, 5).iterator();
        Iterator<Integer> i3 = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();
        Iterator<Iterator<Integer>> it = Arrays.asList(i1,i2, i3).iterator();

        Converter converter = new Converter();
        Iterator<Integer> iterator = converter.convert(it);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

    }

}