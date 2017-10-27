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

    /**
     * метод для взаимодействия с пользователем.
     * возвращает код элемента меню которе выбрал пользователь.
     * @param question вопрос пользователю
     * @param range массив индексов меню взаимодействия с пользователем
     * @return возвращает элемнт
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (key == value) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("out of menu range.");
        }
    }
}
