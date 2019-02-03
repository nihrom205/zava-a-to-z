package ru.job4j.io;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 01.02.2019
 */
public class Compression {
    private String exclude = "";
    private ZipOutputStream zout = null;
    File file = null;

    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("недостатьчно параметов");
            return;
        }
        Compression compress = new Compression();
        compress.init(args);
        compress.zip();
        System.out.println("Архивирование директории завершено.");
    }

    /**
     * Inicialized variables.
     * @param args argumets comand line.
     */
    private void init(String[] args) {
        try {
            if (args[0].equals("-d")) {
                file = new File(args[1]);
                if (!file.exists()) {
                    System.out.println("Каталог не найден.");
                    return;
                }
            }
            if (args[2].equals("-e")) {
                exclude = args[3];
            }
            if (args[4].equals("-o")) {
                zout = new ZipOutputStream(new FileOutputStream(args[5]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * zipping files. not zip files to variable "exclude".
     */
    private void zip() {
        Queue<File> files = new LinkedList<>();
        if (!file.isDirectory()) {
            return;
        }
        try {
            BufferedReader br = null;
            files.add(file);
            while (!files.isEmpty()) {
                File curentFile = files.poll();
                if (curentFile.isDirectory()) {
                    for (File f : curentFile.listFiles()) {
                        if (f.isDirectory()) {
                            files.add(f);
                        } else if (!f.getName().equals(exclude)) {
                            write(f, br);
                        }
                    }
                }
            }
            zout.flush();
            zout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method write to zip file.
     * @param f wrte file.
     * @param br read file.
     */
    private void write(File f, BufferedReader br) {
        try {
            zout.putNextEntry(new ZipEntry(f.getPath()));
            br = new BufferedReader(new FileReader(f));
            while (br.ready()) {
                zout.write(br.readLine().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
