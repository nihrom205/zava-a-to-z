package ru.job4j.deviceAutomate;

import java.util.Arrays;

/**
 * Описание.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 10.11.2017
 */
public class Automate {
    /**
     *  Метод принимает денежные средства и выбирается цена за товар.
     *  далее в массиве возвращается сдача 10, 5, 2 или 1 рубль.
     * @param value денежные средства
     * @param price цена
     * @return массив сдачи
     */
    public int[] changes(int value, int price) {
        int coinTen = 0;
        int coinFive = 0;
        int coinTwo = 0;
        int coinOne = 0;
        int pointArray = 0;


        int surrenderMoney = value - price;
        int[] surrender = new int[surrenderMoney / 10 + 5];

        if (surrenderMoney > 0) {
            coinTen = surrenderMoney / 10 ;
            surrenderMoney -= coinTen * 10;
            coinFive = surrenderMoney / 5;
            surrenderMoney -= coinFive * 5;
            coinTwo = surrenderMoney / 2;
            surrenderMoney -= coinTwo * 2;
            coinOne = surrenderMoney / 1;

            pointArray = this.addMoney(surrender, coinTen, 10, pointArray);
            pointArray = this.addMoney(surrender, coinFive, 5, pointArray);
            pointArray = this.addMoney(surrender, coinTwo, 2, pointArray);
            pointArray = this.addMoney(surrender, coinOne, 1, pointArray);


        }
        return Arrays.copyOf(surrender, pointArray);
    }

    /**
     *  метод добавляет деньги в массив выдачи.
     * @param array массив для добавления денег
     * @param count количество монет номинала valueMoney
     * @param valueMoney номинал монет для добавления в массив
     * @param pointArray текущая позиция в массиве
     * @return позиция в массиве
     */
    private int addMoney(int[] array, int count, int valueMoney, int pointArray) {
        for (int i = 0; i < count; i++) {
            array[pointArray++] = valueMoney;
        }
        return pointArray;
    }

}
