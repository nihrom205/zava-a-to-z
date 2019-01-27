package ru.job4j.io;

import java.io.File;
import java.util.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.01.2019
 */
public class Search {
    public List<File> files(String parent, List<String> exts) {
        String path = System.getProperty("java.io.tmpdir") + File.separator + parent;
        Queue<File> queDirectory = new LinkedList<>();
        List<File> listFiles = new LinkedList<>();


        File dir = new File(path);
        if (!dir.isDirectory()) {
            return new ArrayList<>();
        }
        queDirectory.offer(dir);
        while (!queDirectory.isEmpty()) {
            dir = queDirectory.poll();
            for (File f : dir.listFiles()) {
                if (f.isDirectory()) {
                    queDirectory.offer(f);
                } else {
                    for (String ext : exts) {
                        if (f.getName().endsWith(ext)) {
                            listFiles.add(f);
                        }
                    }
                }
            }
        }

        return listFiles;
    }
}
