package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 20.10.2017
 */
public class ConsoleInput implements Input {
    /**
     * переменаая сканер.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * метод спрашивает пользователя возвращает ответ пользователя.
     * @param question переданный вопрос
     * @return возвращает ответ
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
