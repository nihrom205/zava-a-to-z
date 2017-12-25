package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class Testing SimpleHashSet.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 19.12.17
 */
public class SimpleHashSetTest {

    @Test
    public void whenAddHashSetStringsThenAddadStrings() {
        SimpleHashSet<String> arr = new SimpleHashSet<>(3);

        assertThat(arr.add("one"), is(true));
        assertThat(arr.add("two1"), is(true));
        assertThat(arr.add("tree"), is(true));
        assertThat(arr.add("tree"), is(false));
        assertThat(arr.add("11123"), is(true));
        assertThat(arr.add("223231"), is(true));
    }

    @Test
    public void whenAddHashSetIntegerThenAddadInteger() {
        SimpleHashSet<Integer> arr = new SimpleHashSet<>();

        assertThat(arr.add(1), is(true));
        assertThat(arr.add(2), is(true));
        assertThat(arr.add(3), is(true));
        assertThat(arr.add(2), is(false));
        assertThat(arr.add(124), is(true));
        assertThat(arr.add(432), is(true));
    }

    @Test
    public void whenContainStringsThenTrueAndFalse() {
        SimpleHashSet<String> arr = new SimpleHashSet<>();
        arr.add("aaa");
        arr.add("bbb");
        arr.add("ccc");
        arr.add("ddd");
        arr.add("fff");

        assertThat(arr.contains("aaa"), is(true));
        assertThat(arr.contains("bad"), is(false));
        assertThat(arr.remove("fff"), is(true));
        assertThat(arr.remove("bad"), is(false));
    }
}