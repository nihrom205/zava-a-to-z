package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class Testing class TreeBinApp.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 03.01.2018
 */
public class TreeBinAppTest {

    @Test
    public void whenAddTreeElementsThenAddigElements() {
        TreeBinApp<Integer> tree = new TreeBinApp<>(8);
        assertThat(tree.add(10), is(true));
        assertThat(tree.add(5), is(true));
        assertThat(tree.add(2), is(true));
        assertThat(tree.add(7), is(true));
        assertThat(tree.add(6), is(true));
    }

    @Test
    public void whenAddTreeElementThenIterableElements() {
        TreeBinApp<Integer> tree = new TreeBinApp<>(8);
        Iterator<Integer> it = tree.iterator();
        tree.add(10);
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }
}