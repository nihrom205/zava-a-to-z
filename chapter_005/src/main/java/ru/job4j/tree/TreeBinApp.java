package ru.job4j.tree;

import java.util.*;

/**
 * Class TreeBinApp.
 *  Класс Бинарного дерева.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 03.01.2018
 */
public class TreeBinApp<E extends Comparable<E>> implements Iterable<E> {
    private NodeBin<E> root;    // корень дерева
    private NodeBin<E> current;     // переменная для хранения текущего корня дерева, используется для добавления узлов

    /**
     * Конструктор.
     * @param e
     */
    public TreeBinApp(E e) {
        this.root = new NodeBin<>(e);
        this.current = this.root;
    }

    /**
     * Добавление элементов в бинарное дерево.
     * @param e элемент добавлениея
     */
    public boolean add(E e) {
        boolean isAdded = false;
        if (current.compareTo(e) > 0) {
            if (current.getLeft() != null) {
                current = current.getLeft();
                add(e);                         // рекурсия
                isAdded = true;
                current = root;
            } else {
                current.setLeft(new NodeBin<>(e));
                isAdded = true;
            }
        } else {
            if (current.getRight() != null) {
                current = current.getRight();
                add(e);                         // рекурсия
                isAdded = true;
                current = root;
            } else {
                current.setRight(new NodeBin<>(e));
                isAdded = true;
            }
        }
        return isAdded;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    // итератор работает по принцыпу "обход в ширину"
    private class Iter<E> implements Iterator<E> {
        private Queue list = new LinkedList(); // очередь
        private NodeBin curentNode = root;

        @Override
        public boolean hasNext() {
            return curentNode != null;
        }

        @Override
        public E next() {
            NodeBin rezult = curentNode;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (curentNode.getLeft() != null) {
                list.offer(curentNode.getLeft());
            }
            if (curentNode.getRight() != null) {
                list.offer(curentNode.getRight());
            }

            curentNode = (NodeBin) list.poll();
            return (E) rezult.getValue();
        }
    }


}
