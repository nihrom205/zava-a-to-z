package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ConvertList.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 11.11.2017
 */
public class ConvertListTest {

    // из массива в колекцию
    @Test
    public void whenArrayThenList() {
        ConvertList convert = new ConvertList();
        List<Integer> rezult;
        int[][] massiv = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> except = new ArrayList<>();
        except.add(1);
        except.add(2);
        except.add(3);
        except.add(4);
        except.add(5);
        except.add(6);
        except.add(7);
        except.add(8);
        except.add(9);
        rezult = convert.toList(massiv);
        assertThat(except, is(rezult));
    }

    // из колекции в массив
    @Test
    public void whenListThenArray() {
        ConvertList convert = new ConvertList();
        int[][] except = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 0, 0}};
        List<Integer> listArray = new ArrayList<>();
        listArray.add(1);
        listArray.add(2);
        listArray.add(3);
        listArray.add(4);
        listArray.add(5);
        listArray.add(6);
        listArray.add(7);
        listArray.add(8);
        listArray.add(9);
        listArray.add(10);
//        listArray.add(11);
//        listArray.add(12);

        int[][] rezult =  convert.toArray(listArray, 3);
        assertThat(except, is(rezult));
    }
}
