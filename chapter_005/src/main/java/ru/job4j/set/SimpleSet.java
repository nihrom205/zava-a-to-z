package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleSet.
 * имитация колекции set (множества). в множетсве не может быть дубликатов.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 17.12.2017
 */
public class SimpleSet<T> implements SimpleContainerSet<T> {
    private Object[] array;
    private int index = 0;

    /**
     * Конструктор по умолчанию, создает массив размероностью 100 элементов.
     */
    public SimpleSet() {
        array = new Object[100];
    }

    /**
     * Конструктор с пораметром, создает массива размером value.
     */
    public SimpleSet(int value) {
        array = new Object[value];
    }

    /**
     * метод для добавления в масив элементов.
     * @param t
     */
    @Override
    public void add(T t) {
        boolean isEmty = true;  // пустой - true.

        // в цикле проверяем есть ли значение t в массиве.
        // если есть меняем isEmpty на false и выходим из цикла.
        if (index == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, index);
            array = newArray;
        }

        for (int i = 0; i < index ; i++) {
            if (((T)array[i]).equals(t)) {
                isEmty = false;
                break;
            }
        }

        // если isEmty = true, то в массиве нет значения t,
        // добавляем в массив значение t
        if (isEmty) {
            array[index++] = t;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleSetIter<T>();
    }

    private class SimpleSetIter<T> implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return (cursor < index);
        }

        @Override
        public T next() {
            T rezult = null;
            if (hasNext()) {
                rezult = (T)array[cursor++];
            } else {
                throw new NoSuchElementException();
            }
            return rezult;
        }
    }
}
