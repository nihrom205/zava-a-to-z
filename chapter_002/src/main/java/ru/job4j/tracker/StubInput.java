package ru.job4j.tracker;

/**
 * класс для автоматического тестирования методов.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 22.10.2017
 */
public class StubInput implements Input {
    /**
     * список запросов.
     */
    private String[] answer;

    /**
     * пизиция в списке.
     */
    private int position = 0;

    /**
     * Коструктор.
     * @param answer список запросов
     */
    public StubInput(String[] answer) {
        this.answer = answer;
    }

    /**
     * метод возвращает позицию из списка последовательно.
     * @param question воопрос
     * @return значение
     */
    @Override
    public String ask(String question) {
        return answer[position++];
    }

    @Override
    public int ask(String question, int[] range) {
        return -1;
    }
}
