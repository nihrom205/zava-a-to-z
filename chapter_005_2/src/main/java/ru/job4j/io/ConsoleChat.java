package ru.job4j.io;

import java.io.*;
import java.util.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 03.02.2019
 */
public class ConsoleChat {

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.start();
    }

    /**
     * Start chat.
     */
    private void start() {
        try (RandomAccessFile ra = new RandomAccessFile("randomText.txt", "r");
             FileWriter log = new FileWriter("file.log")) {
            Random random = new Random();
            Scanner sc = new Scanner(System.in);
            String response = sc.nextLine();
            writeLog(response, log);
            while (! "закончить".equals(response)) {
                if ("стоп".equals(response)) {
                    while (!"продолжить".equals(response)) {
                        response = sc.nextLine();
                        writeLog(response, log);
                    }
                    System.out.println("Продолжаем...");
                } else {
                    String reault = generateText(ra);
                    System.out.println(reault);
                    writeLog(reault, log);
                }
                response = sc.nextLine();
                writeLog(response, log);
            }
            System.out.println("Завершение чата!");
            log.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write log to file
     * @param str word
     * @param f write to file
     */
    private void writeLog(String str, FileWriter f) {
        try {
            f.write(new Date().toString());
            f.write(" | ");
            f.write(str);
            f.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method generate text.
     * @param f words file for generate text.
     * @return word
     */
    private String generateText(RandomAccessFile f) {
        String result = "";
        try {
            long randomLocation = (int)(Math.random() * f.length());
            f.seek(randomLocation);
            String utf8 = new String(f.readLine().getBytes("ISO-8859-1"), "UTF-8");
            String[] words = utf8.split(" ");
            result = words[(int)(Math.random() * words.length)];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
