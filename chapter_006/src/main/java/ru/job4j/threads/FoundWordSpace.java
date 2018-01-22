package ru.job4j.threads;

/**
 * Class FoundWordSpace.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 22.01.2018
 */
public class FoundWordSpace {
    private String text;

    public FoundWordSpace(String text) {
        this.text = text;
    }

    public void runFind() {
        new Thread() {
            @Override
            public void run() {
                int countWord = 0;
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) >= 65 && text.charAt(i) <= 122) {
                        countWord++;
                    }
                }
                System.out.println("Кол-во букв = " + countWord);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                int countSpace = 0;
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == 32) {
                        countSpace++;
                    }
                }
                System.out.println("Кол-во пробелов = " + countSpace);
            }
        }.start();
    }
}
