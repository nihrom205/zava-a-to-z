package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 29.12.2017
 */
public class SimpleTreeAppTest {

    @Test
    public void when6ElFindLastThen6() {
        SimpleTreeApp<Integer> tree = new SimpleTreeApp<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 11);
        tree.add(2, 12);
        tree.add(2, 13);
        tree.add(3, 21);
        tree.add(3, 22);
        tree.add(3, 23);

        tree.add(4, 5);
        tree.add(5, 6);

        assertThat(tree.findBy(22).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        SimpleTreeApp<Integer> tree = new SimpleTreeApp<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenIterTrueWhenTrue() {
        SimpleTreeApp<Integer> tree = new SimpleTreeApp<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        Iterator it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(((Node<Integer>) it.next()).eqValue(1), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(((Node<Integer>) it.next()).eqValue(2), is(true));
        assertThat(((Node<Integer>) it.next()).eqValue(3), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(((Node<Integer>) it.next()).eqValue(4), is(true));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenBinaryThenTrueBinary() {
        SimpleTreeApp<Integer> tree = new SimpleTreeApp<>(1);
        assertThat(tree.add(1, 2), is(true));
        assertThat(tree.add(1, 3), is(true));
        assertThat(tree.add(1, 2), is(false));
        assertThat(tree.add(2, 4), is(true));
        assertThat(tree.add(2, 5), is(true));
        assertThat(tree.add(3, 6), is(true));
        assertThat(tree.add(3, 7), is(true));
        assertThat(tree.add(3, 8), is(true));
        assertThat(tree.isBinary(), is(false));
    }

}