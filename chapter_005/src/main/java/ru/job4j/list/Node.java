package ru.job4j.list;

/**
 * Class Node<T>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 16.12.2017
 */
public class Node<T> {
    private T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
