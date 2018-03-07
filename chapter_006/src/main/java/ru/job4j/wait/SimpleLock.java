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
    private Thread lockThred = null;
    private int lockCount = 0;

    public void lock() {
        Thread curThread = Thread.currentThread();
        while (block && lockThred != curThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        block = true;
        lockCount++;
        lockThred = curThread;
    }

    public void unlock() {
        if (Thread.currentThread() == this.lockThred) {
            lockCount--;
        }
        if (lockCount == 0) {
            block = false;
            notify();
        }
    }

}
