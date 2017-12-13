package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 13.12.2017
 */
public class SimpleArray<E> implements SimpleContainer<E> {
    private Object[] array;
    private int index = 0;

    public SimpleArray() {
        array = new Object[100];
    }

    public SimpleArray(int value) {
        array = new Object[value];
    }

    /**
     *  метод добавляет элемент "обобщенного" типа.
     *  если максимально заполнен массив, то массив увеличивается в двое.
     * @param e элемент для добавления элемента.
     */
    @Override
    public void add(E e) {
        if (index == array.length) {
            Object[] arr = new Object[array.length * 2];
            System.arraycopy(array, 0, arr, 0, index);
            array = arr;
        }
        array[index++] = e;
    }

    /**
     * метод возвращает элемен обобщенного типа по индексу.
     * @param index индекс эдемента в колекции
     * @return возвращает элемент обобщенного типа
     */
    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter<E>();
    }

    class Iter<E> implements Iterator<E> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            boolean rezult = false;
            if (cursor < index) {
                rezult = true;
            }
            return rezult;
        }

        @Override
        public E next() {
            Object value = null;
            if (!hasNext()) {
                throw  new NoSuchElementException();
            }
            return (E) array[cursor++];
        }
    }
}
