package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Class для работы с лямда-функциями.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 17.09.18
 */
public class LamdaFunc {
    List<Double> diapazon(int start, int end, Function<Double, Double> func) {
        List<Double> data = new ArrayList<>();
        for (int i = start; i < end; i++) {
            data.add(func.apply((double)i));
        }
        return data;
    }
}
