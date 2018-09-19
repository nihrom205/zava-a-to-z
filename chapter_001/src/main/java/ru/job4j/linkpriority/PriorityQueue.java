package ru.job4j.linkpriority;

import java.util.LinkedList;
import java.util.stream.Collectors;

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
