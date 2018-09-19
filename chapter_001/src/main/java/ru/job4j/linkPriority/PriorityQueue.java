package ru.job4j.linkPriority;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.09.18
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                tasks.add(i, task);
                return;
            }
        }
        tasks.add(task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
