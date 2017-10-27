package ru.job4j.tracker;

/**
 * интерфейс для взаимодействия с пользователем.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 20.10.2017
 */
public interface Input {
    /**
     * прнимает вопрос и ожидает ответ на него.
     * @param question воопрос
     * @return ответ
     */
    String ask(String question);

    int ask(String question, int[] range);
}
