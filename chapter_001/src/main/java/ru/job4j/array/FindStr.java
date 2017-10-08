package ru.job4j.array;

/**
 * Class ищет встречающуюся строку в строке.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 08.10.2017
 */
public class FindStr {

    /**
     * Метод ищет строку в строке.
     * @param origin массив в котором ищут строку
     * @param sub искомая строка
     * @return вызвращате true- если найдена строка, иначе false
     */
    public boolean contains(String origin, String sub) {
        char[] arrayOrigin = origin.toCharArray();
        char[] arraySub = sub.toCharArray();

        int count = 0;

        for (int i = 0; i < arrayOrigin.length; i++) {
            if (arraySub[0] == arrayOrigin[i] && i + arraySub.length - 1 < arrayOrigin.length) {
                for (int j = 0; j < arraySub.length; j++) {
                    if (arrayOrigin[j + i] == arraySub[j]) {
                        count++;
                    } else {
                        count = 0;
                        break;
                    }
                }
            }
        }

        return count == arraySub.length ? true : false;
    }
}
