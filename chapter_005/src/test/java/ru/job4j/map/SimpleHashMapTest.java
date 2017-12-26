package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.12.2017
 */
public class SimpleHashMapTest {

    @Test
    public void whenAddStringToHashMapThenAddedArray() {
        SimpleHashMap<String, Integer> arr = new SimpleHashMap<>();
        assertThat(arr.insert("one", 1), is(true));
        assertThat(arr.insert("two", 2), is(true));
        assertThat(arr.insert("tree", 3), is(true));
    }

    @Test
    public void whenGetStringToHashMapThenReturnValue() {
        SimpleHashMap<String, Integer> arr = new SimpleHashMap<>();
        arr.insert("one", 1);
        arr.insert("two", 2);
        arr.insert("tree", 3);

        assertThat(arr.get("two"), is(2));
        assertThat(arr.get("tree"), is(3));
//        assertThat(arr.get("bad"), is(null));
    }

    @Test
    public void whenDeleteStringToHashMapThenDeletingObjectToArray() {
        SimpleHashMap<Integer, String> arr = new SimpleHashMap<>();
        arr.insert(1, "one");
        arr.insert(2, "two");
        arr.insert(3, "tree");
        arr.insert(4, "four");
        arr.insert(5, "five");

        assertThat(arr.delete(3), is(true));
        assertThat(arr.delete(5), is(true));
        assertThat(arr.delete(100), is(false));
    }

}