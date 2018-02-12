package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class SimpleBlockingQueue.
 *
 * потокобезопасная очередь (потокобезопасная)
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 08.02.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("queue")
    private final Queue<T> queue = new LinkedList<>();

    @GuardedBy("queue")
    private int limit = 3;

    /**
     * метод позволяет добавлять значение в очередь.
     * @param value добавляемый элемент
     * @throws InterruptedException
     */
    public void offer(T value) throws InterruptedException {
        synchronized (this.queue) {
            if (this.queue.size() == this.limit) {
                this.queue.wait();
            }
            this.queue.offer(value);
            this.queue.notify();
        }
    }

    /**
     * метод извлекает из вершины очереди элемент.
     * @return извелченный элемент
     * @throws InterruptedException
     */
    public T peek() throws InterruptedException {
        synchronized (this.queue) {
            if (this.queue.isEmpty()) {
                this.queue.wait();
            }
            this.queue.notify();
            return this.queue.poll();
        }
    }

    public boolean isEmptyQue() {
        synchronized (this.queue) {
            return this.queue.isEmpty();
        }
    }
}
