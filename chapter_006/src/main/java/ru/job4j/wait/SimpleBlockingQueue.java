package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 08.02.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    @GuardedBy("this")
    private int size = 10;
    @GuardedBy("this")
    private int pozition = 0;

    public void offer(T value) throws InterruptedException {
        synchronized (queue) {
            if (pozition >= size) {
                this.wait();
            }
            queue.offer(value);
        }
    }

    public T peek() throws InterruptedException {
        synchronized (queue) {
            if (queue.isEmpty()) {
                this.wait();
            }
        }
        pozition--;
        return queue.poll();
    }
}
