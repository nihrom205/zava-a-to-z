package ru.job4j.threads;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 22.01.2018
 */
public class FoundWordSpaceTest {
    @Test
    public void whenFindWordAndSpaceThenCountWordAndSpace() {
//        FoundWordSpace fount = new FoundWordSpace(" AZaza vv dd");
//        fount.runFind();


        String text = " AZaza vv dd";
        int countSpace = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 32) {
                countSpace++;
            }
        }
        System.out.println("Кол-во пробелов = " + countSpace);
    }
}