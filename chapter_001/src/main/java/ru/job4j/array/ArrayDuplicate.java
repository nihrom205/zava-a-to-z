package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 28.09.2017
 */
public class ArrayDuplicate {
    /**
     * метод возвращает массив без дубликатов.
     * @param array входящий массив строк
     * @return массив без дубликатов
     */
    public String[] remove(String[] array) {
        int sizeArray = array.length;
        for (int in = 0; in < sizeArray - 1; in++) {
            for (int out = in + 1; out < sizeArray; out++) {
                if (array[in].equals(array[out])) {
                    array[out] = array[sizeArray - 1];
                    sizeArray--;
                    out--;
                }
            }
        }
        return Arrays.copyOf(array, sizeArray);
    }
}
