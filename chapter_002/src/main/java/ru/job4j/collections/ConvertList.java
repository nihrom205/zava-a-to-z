package ru.job4j.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertList.
 * Конвертация двумерного массива в ArrayList и наоборот/
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 11.11.2017
 */
public class ConvertList {

    /**
     * метод переводит двумерный массив в List.
     * @param array двумерный массив
     * @return коллекция List
     */
    public List<Integer> toList(int[][] array) {
        int lengthArray = array.length * array[0].length;
        List<Integer> list = new ArrayList<>(lengthArray);
        for (int[] ints : array) {
            for (int value : ints) {
                list.add(value);
            }
        }
        return list;
    }

    /**
     * метод переводит List в двумерный массив, если количество не кратно rows то остальное заполнить 0(нулями).
     * @param list коллекция List
     * @param rows количество элементов в строку в думерном массиве
     * @return двумерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int position = 0;
        int group = 0;

        if (list.size() % rows == 0) {
            group = list.size() / rows;
        } else {
            group = (list.size() / rows) + 1;
        }

        int[][] mass = new int[group][rows];
        for (int i = 0; i < group; i++) {
            for (int j = 0; j < rows; j++) {
                if (list.size() != position) {
                    mass[i][j] = list.get(position++);
                } else {
                    mass[i][j] = 0;
                }
            }
        }
        return mass;
    }
}
