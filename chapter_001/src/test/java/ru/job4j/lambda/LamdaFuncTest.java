package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 17.09.18
 */
public class LamdaFuncTest {
    private List<Double> list = new ArrayList<>();
    private LamdaFunc func = new LamdaFunc();
    @Test
    public void whenNumberAddThenLineFunction() {
//        List<Double> list;

        list = func.diapazon(1, 10, n -> n);
        assertThat(list, is(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)));
    }

    @Test
    public void whenNumberAddThenSquareFunction() {
        list = func.diapazon(1, 10, n -> n * n);
        assertThat(list, is(Arrays.asList(1.0, 4.0, 9.0, 16.0, 25.0, 36.0, 49.0, 64.0, 81.0)));
    }

    @Test
    public void whenNumberAddThenLogorifmFunction() {
        list = func.diapazon(1, 10, n -> Math.log(n));
        assertThat(list, is(Arrays.asList(0.0, 0.6931471805599453, 1.0986122886681098, 1.3862943611198906, 1.6094379124341003, 1.791759469228055, 1.9459101490553132, 2.0794415416798357, 2.1972245773362196)));
    }
}