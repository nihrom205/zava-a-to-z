package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class ChekedNodeCycleTest.
 * тестирует список на зацикленность.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 16.12.2017
 */
public class ChekedNodeCycleTest {

    /**
     * проверка есть цикл
     */
    @Test
    public void whenAddNodeThenHasCycleTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> tree = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);

        first.next = two;
        two.next = tree;
        tree.next = two;

        assertThat(ChekedNodeCycle.hasCycle(first), is(true));
    }

    /**
     * проверка когда нет зацикленности
     */
    @Test
    public void whenAddNodeThenHasCycleFalse() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> tree = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);

        first.next = two;
        two.next = tree;
        tree.next = four;
        four.next = five;

        assertThat(ChekedNodeCycle.hasCycle(first), is(false));
    }

}