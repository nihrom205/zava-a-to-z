package ru.job4j.jmm;

/**
 * Class ThreadProblems.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.01.2018
 */
public class ThreadProblems extends Thread {
    public Boolean cancel = true;

    public static void main(String[] args) throws InterruptedException {
        ThreadProblems t1 = new ThreadProblems();
        t1.start();

        Thread.sleep(1000);
//        t1.cancel = false;
        System.out.println("buy");
    }

    @Override
    public void run() {

        Thread thread1 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                cancel = false;
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                while (cancel) {
                    int temp = 0;
                }
            }
        };

        thread1.start();
        thread2.start();

    }


}
