package ru.job4j.set;

/**
 * Interface Set.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 17.12.2017
 */
public interface SimpleContainerSet<T> extends Iterable<T> {
    void add(T value);
}
