package ru.job4j.noBlock;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 07.04.2018
 */
public class Model {
    private int id;
    private int version;
    private String name;

    public Model(int id, String name) {
        this.id = id;
        this.name = name;
        this.version = 1;
    }

    /**
     * Геттеры и сеииеры
     */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
