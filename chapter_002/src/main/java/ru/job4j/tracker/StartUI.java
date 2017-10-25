package ru.job4j.tracker;

import java.util.Calendar;
import java.util.Formatter;


/**
 * Класс для вывода меню.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 20.10.2017
 */
public class StartUI {
    /**
     * хранит в себе объект пользовательского интерфейса.
     */
    private Input input;

    /**
     * Объект с хранилищем заявок.
     */
    private Tracker tracker = null;

    /**
     * Конструктор.
     * @param input пользовательский интерфейс
     * @param tracker хранилище заявок
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Конструктор .
     * @param input пользовательский интерфейс
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Инициализация программы.
     */
    public void init() {
        if (tracker == null) {
            tracker = new Tracker();
        }

        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillAction();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit? (y): ")));
    }

    /**
     * точка входа в программу.
     * @param args аргументы
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }
}
