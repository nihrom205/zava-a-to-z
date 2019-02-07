package ru.job4j.socet.bot.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 05.02.2019
 */
public class Client {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 5000;

        try {
            Socket socket = new Socket(InetAddress.getByName(ip), port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);
            do {
                out.println("hello oracle");
                String str;
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
