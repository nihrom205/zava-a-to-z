package ru.job4j.wait;


/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 11.02.2018
 */
public class SimpleLock {
    private boolean block = false;

    public void lock() {
        if (block) {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            block = true;
        }
    }

    public void unlock() {
        if (block) {
            block = false;
            Thread.currentThread().notifyAll();
        }
    }

}
