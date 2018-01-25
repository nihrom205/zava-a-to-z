package ru.job4j.threads;

/**
 * Class PrintInfoEnd.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 25.01.2018
 */

public class PrintInfoEnd {
    private Thread t;

    /**
     * Конструктор
     */
    public PrintInfoEnd() {
        System.out.println("Начальная страница!");

        t = new Thread(new ThredPrintInfo(), "thredPrintInfo");
        t.start();

        try {
            t.join();   // ожидание завершения нити t
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Конец программы");
    }

    /**
     * класс имитирует выполнения потока продолжительного времени.
     */
    private class ThredPrintInfo implements Runnable {
        @Override
        public void run() {
            for (int i = 20; i > 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
