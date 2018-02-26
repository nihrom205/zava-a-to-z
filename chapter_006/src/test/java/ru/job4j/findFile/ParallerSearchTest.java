package ru.job4j.findFile;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 28.02.2018
 */
public class ParallerSearchTest {
    @Test
    public void whenFindFile() {
        String path = "c:\\tools";
        String text = "Монитор";
        List<String> exts = new LinkedList<>();
        exts.add("txt");
        ParallerSearch parall = new ParallerSearch(path, text, exts);
        parall.init();

        for (String s : parall.result()) {
            System.out.println(s);
        }


    }
}