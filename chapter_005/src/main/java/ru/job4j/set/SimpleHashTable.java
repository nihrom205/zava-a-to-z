package ru.job4j.set;

/**
 * Class <Name>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 18.12.17
 */
public interface SimpleHashTable<E> {
    boolean add(E e);
    boolean contains(E e);
    boolean remove(E e);
}
