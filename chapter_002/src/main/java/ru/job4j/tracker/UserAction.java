package ru.job4j.tracker;

/**
 * Interface UserAction.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 25.10.2017
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
