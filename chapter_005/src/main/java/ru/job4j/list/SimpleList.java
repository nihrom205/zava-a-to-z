package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

/**
 * Class SimpleList.
 * контейнер LinkedList для хранения элементов обобщенного типа.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 14.12.2017
 */
@SuppressWarnings("ALL")
@ThreadSafe
public class SimpleList<E> implements SimpleContainer<E> {
    @GuardedBy("this")
    protected Node<E> first;
    @GuardedBy("this")
    protected Node<E> end;
    @GuardedBy("this")
    protected int index = 0;

    /**
     * добавление элемента в конец.
     * @param e элемент для добавления в колекцию
     */
    @Override
    public synchronized void add(E e) {
        Node<E> newNode = new Node<>(index++, e);
        if (first == null) {
            first = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
    }

    /**
     * возвращение элемента по индексу.
     * @param index индекс элемента в колекции
     * @return элемент
     */
    @Override
    public synchronized E get(int index) {
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
        return (E) rezult.eData;
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
    @NotThreadSafe
    class SimpleListIter implements Iterator<E> {
        @SuppressWarnings("FieldAccessNotGuarded")
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
    @NotThreadSafe
    protected class Node<E> {
        int key;
        E eData;
        Node<E> next;

        Node(int key, E eData) {
            this.key = key;
            this.eData = eData;
        }
    }


}
