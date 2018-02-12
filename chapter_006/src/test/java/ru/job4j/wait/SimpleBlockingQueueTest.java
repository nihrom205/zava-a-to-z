package ru.job4j.wait;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class SimpleBlockingQueueTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 08.02.2018
 */
public class SimpleBlockingQueueTest {
    private Thread procedure;
    private Thread consumer;
    private final ArrayList<Integer> rezult = new ArrayList<>();

    // помещает данные в очередь.
    private class Procedure extends Thread {
        final SimpleBlockingQueue queue;

        private Procedure(SimpleBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    this.queue.offer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    // извлекает данные из очереди.
    private class Consumer extends Thread {
        final SimpleBlockingQueue queue;

        private Consumer(SimpleBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (procedure.isAlive()) {
                addArr();
                System.out.println("proc");
            }

            while (!queue.isEmptyQue()) {
                addArr();
                System.out.println("isEmptyQue");
            }
        }

        /**
         * метод добавляет в массив взятые из очереди значения
         */
        private void addArr() {
            try {
                int temp = (Integer) queue.peek();
                rezult.add(temp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void whenTwoThredThenSynchronize() {
        SimpleBlockingQueue<Integer> blockingQueue = new SimpleBlockingQueue<>();

        // создание нитей
        procedure = new Procedure(blockingQueue);
        consumer = new Consumer(blockingQueue);


        // запуск нитей
        procedure.start();
        consumer.start();

        try {
            procedure.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> arrInt = new ArrayList<>(Arrays.asList(array));

        assertThat(arrInt, is(rezult));
    }

}