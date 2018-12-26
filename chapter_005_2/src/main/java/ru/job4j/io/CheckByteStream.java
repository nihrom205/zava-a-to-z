package ru.job4j.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 26.12.2018
 */
public class CheckByteStream {
    public boolean isNumber(InputStream in) {
        boolean rezult = false;
        int num;
        try {
            while ((num = in.read()) != -1) {
                char bt = (char) num;
                if (Character.isDigit(bt) && (Character.getNumericValue(bt) % 2 == 0)) {
//                    System.out.println("rezult = " + );
                    rezult = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return rezult;
    }
}
