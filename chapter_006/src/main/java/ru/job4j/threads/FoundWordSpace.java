package ru.job4j.threads;

/**
 * Class FoundWordSpace.
 *
 * Класс подсчитывает кол-во слова в тексте и кол-во пробелов.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 22.01.2018
 */
public class FoundWordSpace {
    private String text;
    private int countWord = 0;
    private int countSpace = 0;

    public FoundWordSpace(String text) {
        this.text = text;
    }

    // Геттеры ======================
    public int getCountWord() {
        return countWord;
    }

    public int getCountSpace() {
        return countSpace;
    }
    //=============================

    /**
     * метод подчета слов и пробелов
     */
    public void runFind() {
        new Thread("thredWord") {
            @Override
            public void run() {
                boolean isWord = false;
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) >= 65 && text.charAt(i) <= 122) {
                        isWord = true;
                    } else if (text.charAt(i) == 32 && isWord) {
                        countWord++;
                        isWord = false;
                    }
                }
                if (isWord) {
                    countWord++;
                }
//                System.out.println("Кол-во букв = " + countWord);
            }
        }.start();

        new Thread("thredSpace") {
            @Override
            public void run() {
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == 32) {
                        countSpace++;
                    }
                }
            }
        }.start();
    }


}
