package ru.job4j.socet.chat.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 04.02.2019
 */
public class Client {
    public static void main(String[] args) {
        int serPort = 5000;
        String address = "127.0.0.1";

        try {
            InetAddress inetAddress = InetAddress.getByName(address);
            System.out.println("Подключение к серверу: " + serPort);
            Socket socket = new Socket(address, serPort);

            InputStream socketInStream = socket.getInputStream();
            OutputStream socketOutStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInStream);
            DataOutputStream out = new DataOutputStream(socketOutStream);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String string = null;
            System.out.println("Введите фразу: ");
            while (true) {
                string = br.readLine();
                out.writeUTF(string);
                out.flush();
                string = in.readUTF();
                System.out.println("Сервер прислал: " + string);
                System.out.println("Введите следующее сообщение: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
