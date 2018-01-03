package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class PerformaceArray.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 11.11.2017
 */
public class PerformenceArrayTest {

    @Test
    public void whenArrayListAddStringThenTimeMeasure() {
        PerformanceArray performance = new PerformanceArray();
        long time = 0;
        ArrayList<String> arr = new ArrayList<>();
//        time = performance.add(arr, 10_000_000);
        time = performance.add(arr, 10_000);
        System.out.println("ArrayList adding: " + time);
        time = performance.delete(arr, 10_000);
        System.out.println("ArrayList delete: " + time);

        LinkedList<String> arrLinked = new LinkedList<>();
//        time = performance.add(arrLinked, 10_000_000);
        System.out.println("LinkedList adding: " + time);
//        time = performance.delete(arrLinked, 10_000);
        System.out.println("LinkedList delete: " + time);

        TreeSet<String> treeset = new TreeSet<>();
//        time = performance.add(treeset, 10_000_000);
        System.out.println("TreeSet adding: " + time);
//        time = performance.delete(treeset, 10_000);
        System.out.println("TreeSet delete: " + time);
    }
}
