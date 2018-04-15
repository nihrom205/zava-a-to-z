package ru.job4j.map;

/**
 * Interface SimpleHashMapImpl.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.12.2017
 */
public interface SimpleHashMapImpl<K, V> {
    boolean insert(K key, V value);
    V get(K key);
    boolean delete(K key);
}
