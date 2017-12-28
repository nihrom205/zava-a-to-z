package ru.job4j.tree;

import java.util.Optional;

/**
 * Interface SimpleTree.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 28.12.2017
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    boolean add(E parent, E child);
    Optional<Node<E>> findBy(E value);
}
