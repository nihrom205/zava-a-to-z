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
    private int countWord = 0;
    private int time = 0;
    private Thread t1 = null;
    private Thread t2 = null;

    public StopThred(String text, int time) {
        this.text = text;
        this.time = time;
    }

    public void start() {
        t1 = new Thread(new Time());
        t1.start();
        t2 = new Thread(new CountChar());
        t2.start();
    }

    /**
     * класс отщитывает заданное время  и меняет флаг cancel.
     */
    private class Time implements Runnable {
        @Override
        public void run() {
            long ms = System.currentTimeMillis();
            while ((System.currentTimeMillis() - ms) < (time * 1000)) {
                int temp = 0;
            }
            t2.interrupt();
        }
    }

    /**
     * класс подсчитывает кол-во слов в тексте, и если флаг cancel=false - цикл завершается
     */
    private class CountChar implements Runnable {
        @Override
        public void run() {
            boolean isWord = false;
            try {
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
            } catch (Exception e) {
//                e.printStackTrace();
            }
//            System.out.println("Кол-во: " + countWord);
        }
    }

    public int getCountWord() {
        return countWord;
    }

    public Thread getT1() {
        return t1;
    }
}
