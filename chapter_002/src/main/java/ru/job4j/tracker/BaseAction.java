package ru.job4j.tracker;

/**
 * Описание.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 28.10.2017
 */
public abstract class BaseAction implements UserAction {
    private String name;
    private int key;

    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    public abstract int key();
    public abstract void execute(Input input, Tracker tracker);
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
