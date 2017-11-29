package ru.job4j.generic;

import java.util.Arrays;

/**
 * Class SimpleArra.
 * контейнер для хранения данных определенного (через Generic) типа.
 * с методами add, update, delete, get(int index).
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 29.11.2017
 */
public class SimpleArray<T> {
    private Object[] mass;  // массив объектов
    private int index = 0;      // индекс массива

    /**
     * Конструктор.
     * @param size  размер массива
     */
    public SimpleArray(int size) {
        this.mass = new Object[size];
    }

    /**
     * метод добавляет элемен в массив.
     * @param value элемент для добавления в массив
     */
    public void add(T value) {
        this.mass[index++] = value;
    }

    /**
     * метод заменяет элемент value на updValue.
     * @param value заменяемое значение
     * @param updValue заменяющее значение
     * @return если успешно то true, иначе false
     */
    public boolean update(T value, T updValue) {
        T iterValue;
        boolean isUpdate = false;
        for (int i = 0; i < mass.length; i++) {
            iterValue = (T) this.get(i);
            if (value.equals(iterValue)) {
                mass[i] = updValue;
                isUpdate = true;
                break;
            }
        }
        return isUpdate;
    }

    /**
     * метод удаляет элемент из массива.
     * @param value удаляемый элемент
     * @return если успешно то true, иначе false
     */
    public boolean delete(T value) {
        T iterValue;
        boolean isDelete = false;
        int size = mass.length;
        for (int i = 0; i < size; i++) {
            iterValue = (T)this.get(i);
            if (value.equals(iterValue)) {
                System.arraycopy(mass, i+1, mass, i, size - i - 1);
                mass[--size] = null;
                isDelete = true;
                break;
            }
        }
        return isDelete;
    }

    /**
     * метод возвращиет элемент по индексу.
     * @param position индекс элемента
     * @return элемент
     */
    public T get(int position) {
        return (T) mass[position];
    }
}
