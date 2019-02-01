package ru.job4j.io;

//import sun.nio.cs.UTF_8;

import javafx.print.Collation;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
                rezult = rezult.replaceAll(Arrays.asList(abuse)
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining("|")), "");
                out.write(rezult.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
