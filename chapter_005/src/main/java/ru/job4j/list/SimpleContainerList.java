package ru.job4j.list;

/**
 * Class Generic.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 14.12.2017
 */
public interface SimpleContainerList<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
}
