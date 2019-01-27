package ru.job4j.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.01.2019
 */
public class DropService {
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        int num;
        StringBuilder sb = new StringBuilder();
        String rezult = "";
        try {
            while ((num = in.read()) != -1) {
                if (' ' != (char)num) {
                    sb.append((char)num);
                } else {
                    rezult = sb.toString();
                    if (!isBloc(rezult, abuse)) {
                        out.write(rezult.getBytes());
                        out.write(' ');
                    }
                    sb.delete(0, sb.length());
                }
            }
            rezult = sb.toString();
            if (!isBloc(rezult, abuse)) {
                out.write(rezult.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * checked String to block list
     * @param s rezult String ti stram
     * @param bloc list block String
     * @return true String find, else false
     */
    private boolean isBloc(String s, String[] bloc) {
        boolean isFind = false;
        for (String str : bloc) {
            if (s.equals(str)) {
                isFind = true;
                break;
            }
        }
        return isFind;
    }
}
