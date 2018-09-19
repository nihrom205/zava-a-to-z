package ru.job4j.linkpriority;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.09.18
 */
public class PriorityQueueTest {
    @Test
    public void whenAddTaskQualityThenSortedToQuality() {
        PriorityQueue priority = new PriorityQueue();
        priority.put(new Task("taskq", 3));
        priority.put(new Task("lekciya", 2));
        priority.put(new Task("Обед", 1));
        priority.put(new Task("спортзал", 8));

        assertThat(priority.take().getDesc(), is("Обед"));
    }

}