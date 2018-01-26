package ru.job4j.threads;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 26.01.2018
 */
public class StopThred {
    private String text;
    private Thread threadTime;
    private Thread threadChar;
    private int countWord = 0;
    private boolean cancel = true;
    private int ms = 0;

    public StopThred(String text, int ms) {
        this.text = text;
        this.ms = ms;
        threadTime = new Thread(new Time());
        threadChar = new Thread(new CountChar());

        threadChar.start();
        threadTime.start();

        try {
            threadTime.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * класс отщитывает заданное время  и меняет флаг cancel.
     */
    private class Time implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(ms * 1000);
                cancel = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * класс подсчитывает кол-во слов в тексте, и если флаг cancel=false - цикл завершается
     */
    private class CountChar implements Runnable {
        @Override
        public void run() {
            boolean isWord = false;
            // flag - cancel прерывает поток
            for (int i = 0; i < text.length() && cancel; i++) {
                if (text.charAt(i) >= 65 && text.charAt(i) <= 122) {
                    isWord = true;
                } else if (text.charAt(i) == 32 && isWord) {
                    countWord++;
                    isWord = false;
                }

                // задержка для отработки алгоритма
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);

            }
            if (isWord) {
                countWord++;
            }
            System.out.println("Кол-во: " + countWord);
        }
    }
}
