package ru.job4j.threads;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 29.01.2018
 */
public class FoundToText implements Runnable {
    private String text;
    private int countWord;
    private int countSpace;

    public FoundToText(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        foundWorde();
        foundSpace();
    }

    public void foundWorde() {
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
    }

    private void foundSpace() {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 32) {
                countSpace++;
            }
        }
    }

    public int getCountWord() {
        return countWord;
    }

    public int getCountSpace() {
        return countSpace;
    }
}
