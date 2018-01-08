package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleLinkedListSet.
 * создание Set на базе LinkedList.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 18.12.17
 */
public class SimpleLinkedListSet<T> implements SimpleContainerSet<T> {
    private Node<T> first;  // первый элемент в set на базе связанного списке
    private Node<T> end;    // последний элемент в set на базе связанного списке
    private int key = 0;  //

    /**
     * метод добавления в set лементов.
     * @param value значение элемента
     */
    @Override
    public void add(T value) {

        /**
         * добавление элемента если к set-е нет такого элемента
         */
        if (isFind(value)) {
            if (first == null) {
                first = new Node<T>(key++, value);
                end = first;
            } else {
                end.next = new Node<T>(key++, value);
                end = end.next;
            }

        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        private Node<T> position = first;

        @Override
        public boolean hasNext() {
            return (position != null);
        }

        @Override
        public T next() {
            T rezult = null;
            if (hasNext()) {
                rezult = position.tDate;
                position = position.next;
            } else {
                throw new NoSuchElementException();
            }
            return rezult;
        }
    }

    /**
     * ячейка  связанного списка
     * @param <T> обобщенный тип
     */
    private class Node<T> {
        private int key;
        private T tDate;
        private Node<T> next;

        public Node(int key, T tDate) {
            this.key = key;
            this.tDate = tDate;
        }
    }

    /**
     * в цикле проверяем  есть ли елемент который мы хотим добавить,
     * @param value искомое значение в списке
     * @return true - не найден, иначе - false.
     */
    private boolean isFind(T value) {
        boolean isEmpty = true;
        Node<T> current = first;
        while (current != null) {
            if ((current.tDate).equals(value)) {
                isEmpty = false;
                break;
            } else {
                current = current.next;
            }
        }
        return isEmpty;
    }
}
