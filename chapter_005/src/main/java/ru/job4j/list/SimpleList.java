package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleList.
 * контейнер LinkedList для хранения элементов обобщенного типа.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 14.12.2017
 */
public class SimpleList<E> implements SimpleContainer<E> {
    private Node<E> first;
    private Node<E> end;
    private int index = 0;

    /**
     * добавление элемента в конец.
     * @param e элемент для добавления в колекцию
     */
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(index++, e);
        if (first == null) {
            first = end = newNode;
        } else {
            end.next = end = newNode;
        }
    }

    /**
     * возвращение элемента по индексу.
     * @param index индекс элемента в колекции
     * @return элемент
     */
    @Override
    public E get(int index) {
        Node<E> rezult = null;
        Node<E> curenPosition = first;
        while (curenPosition != null) {
            if (curenPosition.key == index) {
                rezult = curenPosition;
                break;
            } else {
                curenPosition = curenPosition.next;
            }
        }
        return (E)rezult.eData;
    }

    /**
     * передает итератор.
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleListIter();
    }

    /**
     * class обхода колекции.
     */
    class SimpleListIter implements Iterator<E> {
        Node<E> position = first;
        @Override
        public boolean hasNext() {
            return (position != null);
        }

        @Override
        public E next() {
            E rezult = null;
            if (hasNext()) {
                rezult = position.eData;
                position = position.next;
            } else {
                throw new NoSuchElementException();
            }
            return rezult;
        }
    }

    /**
     * class ячейка LinkedList.
     * @param <E> принимает обобщенный тип.
     */
    private class Node<E> {
        int key;
        E eData;
        Node<E> next;

        Node(int key, E eData) {
            this.key = key;
            this.eData = eData;
        }
    }


}
