package ru.job4j.collections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Class List.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 06.11.2017
 */
public class ListExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(3);
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(0);
        list.add(1);

//        List<Integer> listNew = new ArrayList<>(3);
//        listNew.add(10);
//        listNew.add(78);
//        listNew.add(133);
//        listNew.add(200);
//        listNew.add(44);
//
//        list.addAll(listNew);
//
//        Integer num = list.set(6, 111);
//
//        for (Integer value : list) {
//            System.out.println(value);
//        }
//        System.out.println("num = " + num);

        Integer[] arrInt = new Integer[list.size()];

        arrInt = list.toArray(arrInt);

        for (Integer integer : arrInt) {
            System.out.println(integer);
        }
    }
}
