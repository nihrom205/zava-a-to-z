package ru.job4j.generic;

/**
 * Описание.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 01.12.2017
 */
public abstract class Base {
    private String id = "";

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
