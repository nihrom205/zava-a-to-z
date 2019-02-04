package ru.job4j.socet.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 04.02.2019
 */
public class Server {
    public static void main(String[] args) {
        int port = 5000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Ждем подключения к серверу");
            Socket socket = serverSocket.accept();
            System.out.println("Подключение состоялось");
            InputStream socketInStream = socket.getInputStream();
            OutputStream socketOutStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInStream);
            DataOutputStream out = new DataOutputStream(socketOutStream);

            String str = null;
            while (true) {
                str = in.readUTF();
                System.out.println("мы получили сообщение: " + str);
                System.out.println("отправка обратно");
                out.writeUTF(str);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
