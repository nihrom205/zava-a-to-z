package ru.job4j.tracker;

/**
 * Класс исключения.
 *  @author Alexey Rastorguev (rastorguev00@gmail.com)
 *  @version $0.1$
 *  @since 27.10.2017
 */
public class MenuOutException extends RuntimeException {
    /**
     * Метод исключения, "не правильнный ввод данных", выбран ключ не из меню.
     * @param msg сообщение об ошибке
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
