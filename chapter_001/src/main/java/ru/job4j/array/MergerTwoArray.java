package ru.job4j.array;

/**
 * MergerTwoArray.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 08.10.2017
 */
public class MergerTwoArray {
    /**
     * Метод объединяет 2 массива в 1.
     *
     * @param arrayOne первый массив
     * @param arrayTwo второй массив
     * @return объединенный массив
     */
    public int[] merge(int[] arrayOne, int[] arrayTwo) {
        int sizeArray = arrayOne.length + arrayTwo.length;
        int[] rezult = new int[sizeArray];
        for (int i = 0; i < arrayOne.length; i++) {
            rezult[i] = arrayOne[i];
        }
        for (int j = 0; j < arrayTwo.length; j++) {
            rezult[arrayOne.length + j] = arrayTwo[j];
        }

        BubbleSort buble = new BubbleSort();
        return buble.sort(rezult);
    }
}
