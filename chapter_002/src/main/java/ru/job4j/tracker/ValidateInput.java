package ru.job4j.tracker;

/**
 * Класс для проверки корректности ввода пользователя.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $0.1$
 * @since 27.10.2017
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Метод проверяет корректность ввода пользовательских данных.
     * @param question вопрос пользователю
     * @param range массив индексов меню взаимодействия с пользователем
     * @return введенное значение пользователем
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select from menus.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again!");
            }
        } while (invalid);
        return value;
    }
}
