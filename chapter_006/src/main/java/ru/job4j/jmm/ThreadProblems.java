package ru.job4j.jmm;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.01.2018
 */
public class ThreadProblems extends Thread {
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadProblems t = new ThreadProblems();
        t.start();
        Thread.sleep(1000);
        t.count = 2;

        System.out.println(System.currentTimeMillis() + ": keepRunning is false");
    }

    @Override
    public void run() {
        while (count == 0) {
            System.out.println(0);
        }
    }


}
