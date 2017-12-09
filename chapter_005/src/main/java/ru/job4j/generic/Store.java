package ru.job4j.generic;

/**
 * Описание.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 01.12.2017
 */
public interface Store<T extends Base> {
    T add(T model);
    T update(T model);
    boolean delete(String id);
}
