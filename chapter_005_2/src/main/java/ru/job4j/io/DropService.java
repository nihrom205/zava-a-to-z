package ru.job4j.io;

//import sun.nio.cs.UTF_8;

import java.io.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.01.2019
 */
public class DropService {
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        String rezult = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (br.ready()) {
                rezult = br.readLine();
                for (String s : abuse) {
                    rezult = rezult.replaceAll(s, "");
                }
                out.write(rezult.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
