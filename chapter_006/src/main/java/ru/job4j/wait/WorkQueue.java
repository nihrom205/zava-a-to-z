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
 * @since 09.02.2018
 */
@ThreadSafe
public class WorkQueue {
    @GuardedBy("workQueue")
    private final Queue<Work> workQueue = new LinkedList<>();
    private int proc = Runtime.getRuntime().availableProcessors();
    private Thread[] thredPull = new Thread[proc];

    public WorkQueue() {
        initTred();
    }

    /**
     * Инициализация пула нитей, каждой ните дается уникальное имя.
     */
    private void initTred() {
        for (int i = 0; i < proc; i++) {
            thredPull[i] = new Thread("thred" + i) {
                @Override
                public void run() {
                    while (true) {
                        pr();
                    }
                }
            };
        }
    }

    /**
     * Добавление элемента в очередь
     * @param work элемент
     */
    public void add(Work work) {
        synchronized (this.workQueue) {
            this.workQueue.add(work);
            this.workQueue.notifyAll();
        }
    }

    /**
     * Метод извлекает из очереди элемент работа и выполняет ее.
     * в данном примере печатает ее имя.
     */
    private void pr() {
        synchronized (this.workQueue) {
            if (this.workQueue.isEmpty()) {
                try {
                    this.workQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.workQueue.poll().toString());
        }
    }

    /**
     * метод запускает в работу все нити.
     */
    public void run() {
        for (Thread thread : thredPull) {
            thread.start();
        }
    }


}
