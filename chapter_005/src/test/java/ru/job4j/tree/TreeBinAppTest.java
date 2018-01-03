package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
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

}