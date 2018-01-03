package ru.job4j.tree;

import java.lang.reflect.ParameterizedType;

/**
 * Class NodeBin.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 03.01.2018
 */
public class NodeBin<E extends Comparable<E>> implements Comparable<E> {
    private NodeBin<E> left;
    private NodeBin<E> right;
    private E value;

    /**
     * конструктор
     * @param value значение элемента
     */
    public NodeBin(E value) {
        this.value = value;
    }

    /***********************************
    геттеры и сеттеры
     ************************************/
    public E getValue() {
        return value;
    }

    public NodeBin<E> getLeft() {
        return left;
    }

    public NodeBin<E> getRight() {
        return right;
    }

    public void setLeft(NodeBin<E> left) {
        this.left = left;
    }

    public void setRight(NodeBin<E> right) {
        this.right = right;
    }

    /**
     * метод для сравнения значения в узле с элементом.
     * @param o элемент для сравнения
     * @return -1 - вызываемый элемент меньше "о", 0- равны, 1 -вызывемый эл. больше "о"
     */
    @Override
    public int compareTo(E o) {
        return this.value.compareTo(o);
    }
}
